package AAA熟悉各常使用的类;

import java.util.PriorityQueue;

public class PriorityQueue_ {
        public static void main(String[] args) {
            // 默认是小根堆 也就是优先级高的元素在前面 这里我们改成了大根堆
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> { return b-a;});
            // 下面是添加元素的两种方式 结果是一样的
            pq.offer(1);
            pq.add(3);
            pq.offer(2);
            // 下面是查看队首元素的两种方式 结果是一样的
            System.out.println(pq.peek());
            System.out.println(pq.element());
            // 下面是删除队首元素的两种方式 结果是一样的
//            System.out.println(pq.poll());
//            System.out.println(pq.remove());
            // 下面是查看队列中元素的两种方式 结果是一样的
            Integer a[] = pq.toArray(new Integer[0]);
            for(Integer i : a){
                System.out.println(i);
            }
            // 还有一种方式是直接遍历队列 但是这种方式不保证元素的顺序 因为PriorityQueue底层是一个堆结构 不是一个有序的结构 所以遍历的时候可能会出现元素的顺序不一样的情况
            for(Integer i : pq) {
                System.out.println(i);
            }

        }

}
