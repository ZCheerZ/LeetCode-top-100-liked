package Leetcode成长之路.二分篇;

import java.util.Scanner;

class Q4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(((n1+n2) & 1) == 1) return findK(nums1,nums2,(n1+n2)/2+1); // 第k小个数 所以得+1；
        else return (findK(nums1,nums2,(n1+n2)/2) +  findK(nums1,nums2,(n1+n2)/2+1)) /2;
    }

    public double findK(int[] nums1, int[] nums2 ,int k) {
        int numsIndex1 = 0;
        int numsIndex2 = 0;
        while(true){
            if(numsIndex1 == nums1.length){
                return nums2[numsIndex2+k-1];
            }
            if(numsIndex2 == nums2.length){
                return nums1[numsIndex1+k-1];
            }
            if( k == 1){
                return Math.min(nums2[numsIndex2],nums1[numsIndex1]) ;
            }
            int half = k/2;
            int newnumsIndex1 = Math.min(numsIndex1+half,nums1.length);
            int newnumsIndex2 = Math.min(numsIndex2+half,nums2.length);
            if(nums1[newnumsIndex1-1] < nums2[newnumsIndex2-1]){
                k -=  newnumsIndex1 - numsIndex1;
                numsIndex1 = newnumsIndex1;
            }else{
                k -=  newnumsIndex2 - numsIndex2;
                numsIndex2 = newnumsIndex2;
            }
        }
    }
    public static void main(String[] args) {
        Q4_寻找两个正序数组的中位数 q4寻找两个正序数组的中位数 = new Q4_寻找两个正序数组的中位数();
        Scanner scanner = new Scanner(System.in);

    }
}