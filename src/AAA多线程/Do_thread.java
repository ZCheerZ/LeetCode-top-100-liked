package AAA多线程;

import java.io.Flushable;
import java.util.concurrent.*;

public class Do_thread {
    static class myThread extends Thread {
        private final String threadName;

        myThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadName + " is running.");
        }
    }

    static class myRunnable implements Runnable {
        private final String threadName;

        myRunnable(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            System.out.println("Runnable Thread " + threadName + " is running.");
        }
    }

    static class myCallable implements Callable<String> {
        //        private final String threadName;
//        myCallable(String name){
//            this.threadName = name;
//        }
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "Callable Thread " + Thread.currentThread().getName() + " is running.";
        }
    }

    static class myExecutors implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread Pool Thread " + Thread.currentThread().getName() + " is running.");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        myThread t1 = new myThread("Thread-1");
//        myThread t2 = new myThread("Thread-2");
//        Thread r3 = new Thread(new myRunnable("Runnable-1"));
//        Thread r4 = new Thread(new myRunnable("Runnable-2"));
//        Thread c5 = new Thread(new FutureTask<>(new myCallable()));
        FutureTask<String> fc6 = new FutureTask<>(new myCallable());
//        Thread c6 = new Thread(fc6);
//
//        t1.start();
//        t2.start();
//        r3.start();
//        r4.start();
//        c5.start();
//        c6.start();
//        System.out.println(fc6.get());

        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService = new ThreadPoolExecutor(
                3, 3, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory());

        executorService.execute(new myExecutors()); // fc6可以因为实现了runable new myCallable()不行
        System.out.println("1");
        executorService.submit(new myExecutors());
        System.out.println("2");
        Future<String> t = executorService.submit(new myCallable());
        executorService.shutdown();
        System.out.println("3");
        System.out.println(t.get());
        System.out.println("4");



    }
}
