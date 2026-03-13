package AAA熟悉各常使用的类;

import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueue_ {
        public static void main(String[] args) {
            // 默认是小根堆 也就是优先级高的元素在前面 这里我们改成了大根堆
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> { return b-a;});
            // PriorityQueue允许重复的元素 但是不允许null元素 因为null元素没有办法比较大小
            // 下面是添加元素的两种方式 结果是一样的
            pq.offer(1);
            pq.add(2);
            pq.add(2);
            pq.offer(4);
            // 下面是查看队首元素的两种方式 结果是一样的
            System.out.println(pq.peek());
            System.out.println(pq.element());
            // 下面是删除队首元素的两种方式 结果是一样的
//            System.out.println(pq.poll());
//            System.out.println(pq.remove());
            // 删除指定元素的只有remove  结果是一样的 但是remove不能删重复的元素 只能删第一个出现的元素 poll只能删队首元素 不能删指定元素
            System.out.println(pq.remove(2));
            // 下面是查看队列中元素的两种方式 结果是一样的
            Integer[] a = pq.toArray(new Integer[0]);
            for (Integer i : a) {
                System.out.println(i);
            }
            // 还有一种方式是直接遍历队列 但是这种方式不保证元素的顺序 因为PriorityQueue底层是一个堆结构 不是一个有序的结构 所以遍历的时候可能会出现元素的顺序不一样的情况
            for(Integer i : pq) {
                System.out.println(i);
            }

//            List<Integer> list = new ArrayList<>();
//            int[] array = list.toArray(new int[0]);


        }

}
