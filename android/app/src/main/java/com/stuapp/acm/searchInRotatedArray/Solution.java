package com.stuapp.acm.searchInRotatedArray;


import static android.R.attr.left;
import static android.R.attr.right;

public class Solution {

    public int biSearch(int[] A,int left,int right,int target)
    {
        if(left>right)
            return -1;

        int mid=(left+right)/2;

        if(A[left]==target)
            return left;
        if(A[right]==target)
            return right;
        if(target==A[mid])
            return mid;

        //直接二分查找
        if(A[mid]>target)
            return biSearch(A,mid+1,right-1,target);
        else
            return biSearch(A,left+1,mid-1,target);

    }

    public int search(int[] nums, int target) {
        //对于数组搜索,有三种情况
        //1.完全不分割还是顺序
        //2.分割，pivot居左,导致新的数组左半长于右半
        //3.分割,pivot居右,导致新的数组右半长于左半
        if(nums!=null&&nums.length>0)
        {

            biSearch(nums,0,nums.length-1,target);
        }


        return -1;
    }
}
