package tongji.util.thread;

import java.util.concurrent.*;

public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //继承Thread类实现多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" start");
        }, "thread1").start();

        //覆写Runnable()接口实现多线程
        /*
            Thread中变量target存储Runnable对象
            //private Runnable target;
            public void run()
            {
                if (target != null)
                {
                    target.run();
                }
            }
         */
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+" start");
        };
        new Thread(runnable,"thread2").start();

        //覆写Callable接口实现多线程
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " start");
                Thread.sleep(1000);
                return 100;
            }
        });
        new Thread(task,"thread3").start();
        //一直阻塞直到结果返回
        System.out.println(task.get());

        //通过线程池启动多线程

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //执行
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        //关闭连接
        executorService.shutdown();

    }
}
