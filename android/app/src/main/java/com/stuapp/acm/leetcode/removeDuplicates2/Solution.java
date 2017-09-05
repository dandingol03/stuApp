package com.stuapp.acm.leetcode.removeDuplicates2;


import java.util.HashMap;


/**
 * 不仅要算出来还得进行变换
 */

public class Solution {

    //元素插入
    private void insertNumber(int i,int j,int[] nums)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        for(int k=i+1;k<=j;k++)
        {
            nums[k]=temp;
            temp=nums[k];
        }
    }

    public int removeDuplicates(int[] nums) {

        int result=0;
        HashMap<Integer,Integer> maps=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(maps.containsKey(nums[i]))
            {
                if(maps.get(nums[i])>1)
                {}
                else
                {
                    maps.put(nums[i],2);
                    insertNumber(result,i,nums);
                    result++;
                }
            }else{
                maps.put(nums[i],1);
                insertNumber(result,i,nums);
                result++;
            }
        }

        return result;
    }
}
