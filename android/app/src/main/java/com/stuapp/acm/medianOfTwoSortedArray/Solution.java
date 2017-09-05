package com.stuapp.acm.medianOfTwoSortedArray;

public class Solution {

    private int[]A=null;
    private int[]B=null;
    private int figureOutSentinel(int low ,int high)
    {
        //数组A的哨兵
        int sentinel1=(low+high)/2;
        //数组B的哨兵
        int sentinel2=(A.length+B.length)/2-sentinel1;
        if(sentinel1==0)
        {
           return sentinel1;
        }
        else if(sentinel2==0)
        {
            return sentinel1;
        }else{
            if(sentinel2==B.length)
            {
                if(A[sentinel1]>=B[sentinel2-1])
                {
                    return sentinel1;
                }else if(B[sentinel2-1]>A[sentinel1])
                {
                     return figureOutSentinel(sentinel1,high);
                }else{
                    return figureOutSentinel(low,sentinel1-1);
                }
            }else{
                if(A[sentinel1]>=B[sentinel2-1])
                {
                    if(sentinel2<B.length)
                    {
                        if(A[sentinel1-1]<=B[sentinel2])
                            return  sentinel1;
                        else{
                            return figureOutSentinel(low,sentinel1-1);
                        }
                    }else{
                        return sentinel1;
                    }

                }else if(A[sentinel1-1]>B[sentinel2])
                {
                    //A哨兵过大
                    return figureOutSentinel(low,sentinel1-1);
                }else if (B[sentinel2-1]>A[sentinel1]){
                    //A哨兵过小
                    return figureOutSentinel(sentinel1+1,high);
                }else {
                    return -1;
                }
            }
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        A=nums1;
        B=nums2;
        //
        int i=figureOutSentinel(0,nums1.length);
        int j=(A.length+B.length)/2-i;
        int remainTotalLength=nums1.length-i+nums2.length-j;

        int max1=0;
        int min2=0;
        if(i==0&&j==0)
        {
            max1=0;
        }
        else if(j==0)
        {
            if(nums1.length>0)
                max1=nums1[i-1];
        }
        else if(i==0)
        {
            if(nums2.length>0)
                max1=nums2[j-1];
        }
        else
            max1=Math.max(nums1[i-1],nums2[j-1]);
        if(i==nums1.length)
        {
            min2=nums2[j];
        }else if(j==nums2.length)
        {
            min2=nums1[i];
        }else{
            if(nums1.length>0&&nums2.length>0)
                min2=Math.min(nums1[i],nums2[j]);
            else if(nums1.length>0)
                min2=nums1[i];
            else if(nums2.length>0)
                min2=nums2[j];
            else
                min2=0;
        }
        if(remainTotalLength>i+j)
        {
            return min2;
        }else if(i+j>remainTotalLength)
        {
            return max1;
        }else{
            return (max1+min2)/2.0;
        }

    }
}
