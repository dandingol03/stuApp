package com.stuapp.acm.removeDuplicates;


public class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums!=null&&nums.length>0)
        {
            int i=0;
            int j=0;
            Integer first=null;
            while(j<nums.length)
            {

                if(nums[j]!=nums[i])
                {
                    i++;
                    nums[i]=nums[j];
                }
                j++;
            }
            return i+1;
        }

        return 0;
    }
}
