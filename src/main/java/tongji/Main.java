package tongji;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            //需要检测是否被中断，并且响应
            for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
                System.out.println("Hello + " + i);

                //控制不住，因为调用后中断标志被清除了
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断");
                    break;
                }

                //如果在sleep时中断，就会抛出该异常，所以就可以在catch中处理
                //该循环会继续工作，因为catch后就执行下一轮循环
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException e) {
                    //sleep interrupted
                    e.printStackTrace();
                }
            }
            System.out.println("运行结束了");
        };
        Thread thread = new Thread(runnable);
        thread.start();
        //控制interrupt时线程正在sleep
        TimeUnit.MILLISECONDS.sleep(500);
        thread.interrupt();
    }
}
