package SlidingWindow;

public class MaxSumOfSubArrayofSize_k {
    /*
    * 2461. Maximum Sum of Distinct Subarrays With Length K
    You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

    The length of the subarray is k, and
    All the elements of the subarray are distinct.
    Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

    A subarray is a contiguous non-empty sequence of elements within an array.
    *
    * T.C: O(n)
    * S.C: O(1)
    * */

    public static int maxSum(int[] a, int n, int k) {
        if(n<k) {
            return -1;
        }
        //sum of first window of size k
        int res  = 0;
        for(int i=0; i<k ; i++) {
            res += a[i];
        }
        //find remaining sum by sliding window
        //remove first element from first window sum
        //and add the next element
        //then compare whether maxSum or not
        int maxSum = 0;
        for(int i=k ; i<n ; i++) {
            res = res + a[i] - a[i-k];
            maxSum = Math.max(maxSum, res);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(a, a.length, k));
    }


}
