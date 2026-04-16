package Leetcode成长之路.链表篇;

import java.util.Scanner;

class Q25_K个一组翻转链表 {
    /*
    25. K 个一组翻转链表
    给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    输入：head = [1,2,3,4,5], k = 2
    输出：[2,1,4,3,5]
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        ListNode preHead = new ListNode(-1,head);
        ListNode pre = preHead;
        cur = head;
        ListNode preK = preHead;
        for(int i = k; i<=n; i+=k){
            ListNode nowFirst = cur;
            for(int j = 1; j<=k ; j++){
                ListNode t = cur.next;
                cur.next = pre;
                pre = cur;
                cur = t;
            }
            nowFirst.next = cur;
            preK.next = pre;
            preK = nowFirst;
        }
        return preHead.next;
    }
    public static void main(String[] args) {
        Q25_K个一组翻转链表 q25K个一组翻转链表 = new Q25_K个一组翻转链表();
        Scanner scanner = new Scanner(System.in);

    }
}