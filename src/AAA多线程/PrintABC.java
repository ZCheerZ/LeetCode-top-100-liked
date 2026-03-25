package AAA多线程;

import java.util.concurrent.Semaphore;

public class PrintABC {
    private final Semaphore semA = new Semaphore(1); // 信号量A设置为1,从A开始打印
    private final Semaphore semB = new Semaphore(0);
    private final Semaphore semC = new Semaphore(0);
    private static int n = 3;   // 打印轮次

    public static void main(String[] args) {
        PrintABC PrintABC = new PrintABC();
        new Thread(()->PrintABC.print('A',PrintABC.semA,PrintABC.semB)).start();
        new Thread(()->PrintABC.print('B',PrintABC.semB,PrintABC.semC)).start();
        new Thread(()->PrintABC.print('C',PrintABC.semC,PrintABC.semA)).start();
    }
    public void print(char ch, Semaphore current, Semaphore next) {
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
