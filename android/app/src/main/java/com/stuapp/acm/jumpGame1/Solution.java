package com.stuapp.acm.jumpGame1;


public class Solution {
    public boolean canJump(int[] nums) {

        int faraway=0;

        for(int i=0;i<nums.length;i++)
        {
            if(faraway>=i)
            {
                if(nums[i]+i>faraway)
                    faraway=nums[i]+i;
            }else{
                break;
            }
        }

        if(faraway>=nums.length-1)
            return true;
        else
            return false;


    }
}
