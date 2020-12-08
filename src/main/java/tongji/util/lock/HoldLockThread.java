package tongji.util.lock;

public class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " 持有"+lockA+" 尝试持有 "+lockB);
            synchronized (lockB) {
                System.out.println("都持有了");
            }
        }
    }
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "t1").start();
        new Thread(new HoldLockThread(lockB, lockA), "t2").start();
    }
}
