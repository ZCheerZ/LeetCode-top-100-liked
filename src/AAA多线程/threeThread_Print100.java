package AAA多线程;

public class threeThread_Print100 {
    private static final Object lock = new Object();
    private static int cnt = 0;
    private static final int n = 10;
    static class myrunnable implements Runnable{
        private final int id;
        public myrunnable(int id){
            this.id = id;
        }
        @Override
        public void run() {
            while(cnt < n){
                synchronized (lock){
                    while(cnt % 3 != id){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if(cnt <= n){
                        System.out.println(id+" "+cnt);
                        cnt++;
                        lock.notifyAll();
                    }
                    else {
                        lock.notifyAll();
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new myrunnable(0));
        Thread t2 = new Thread(new myrunnable(1));
        Thread t3 = new Thread(new myrunnable(2));
        t1.start();
        t2.start();
        t3.start();


    }

}
