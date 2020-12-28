package tongji.thread;

import java.util.concurrent.TimeUnit;

public class Thread1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
                System.out.println("业务逻辑");
                throwInMethod();

                //因为重新设置了中断状态，所以是有效的
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("break");
                    break;
                }
            }
        };

        //线程使用
        Thread thread = new Thread(runnable);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

    private static void throwInMethod() {
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e) {
            //恢复设置中断状态，以便于在后续执行时，仍然能够检查到刚刚发生了中断
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
