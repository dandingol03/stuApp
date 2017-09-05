package com.stuapp.acm.searchForRange;

import static android.R.attr.right;

/**
 * 二分查找
 */
public class Solution {

    public int[] biSearch(int[] A,int left,int right,int target)
    {
        if(left>right)
            return new int[]{1,1};
        int mid=(left+right)/2;
        if(target==A[left])
        {
            int low=left;
            int high=-1;

            for(int i=left+1;i<A.length;i++)
            {
                if(A[i]!=target)
                    high=i-1;
            }
            return new int[]{low,high};
        }else if(target==A[right])
        {
            int low=-1;
            int high=right;
            for(int i=right-1;i>=0;i--)
            {
                if(A[i]!=target)
                    low=i+1;
            }
            return new int[]{low,high};

        }else if(A[mid]==target){
            int low=-1;
            int high=-1;
            for(int i=mid-1;i>=0;i--)
            {
                if(A[i]!=target)
                    low=i+1;
            }
            for(int i=mid+1;i<A.length;i++)
            {
                if(A[i]!=target)
                    high=i-1;
            }
            return new int[]{low,high};
        }

        if(A[mid]<target)
        {
            return biSearch(A,mid+1,right-1,target);
        }else{
            return biSearch(A,left+1,mid-1,target);
        }




    }

    public int[] searchRange(int[] nums, int target) {

        return null;
    }
}
