package AAA多线程;

import java.util.concurrent.Semaphore;

public class PrintABC {
    private static final Semaphore semA = new Semaphore(1); // 信号量A设置为1,从A开始打印
    private static final Semaphore semB = new Semaphore(0);
    private static final Semaphore semC = new Semaphore(0);
    private static final int n = 100;   // 打印轮次



    public static void main(String[] args) {
        new Thread(()->print('A',semA,semB)).start();
        new Thread(()->print('B',semB,semC)).start();
        new Thread(()->print('C',semC,semA)).start();
    }
    public static void print(char ch, Semaphore current, Semaphore next) {
        try {
            for (int i = 0; i < n; i++) {
                current.acquire();  // 获取当前信号量
                System.out.println(Thread.currentThread().getName() + ": " + ch);
                next.release();     // 释放下一个信号量
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
