package com.stuapp.acm.sortColors;



public class Solution {
    private final int RED=0;
    private final int WHITE=1;
    private final int BLUE=2;
    public void sortColors(int[] nums) {


        if(nums.length==1)
        {}else{
            int redSentinel=0;
            int blueSentinel=nums.length-1;
            //单向扫描
            int i=0;
            while(i<nums.length&&redSentinel<=blueSentinel&&i<=blueSentinel)
            {
                if(nums[i]== RED) {
                    if(i==redSentinel)
                    {
                        redSentinel++;
                    }else{
                        int temp = nums[redSentinel];
                        nums[redSentinel++] = RED;
                        nums[i] = temp;
                        if(temp==BLUE&&blueSentinel!=redSentinel)
                        {
                            nums[i]=nums[blueSentinel];
                            nums[blueSentinel--]=BLUE;
                        }else if(temp==RED)
                        {
                            temp=nums[redSentinel];
                            nums[redSentinel++]=RED;
                            nums[i]=temp;
                        }
                    }
                }else if(nums[i]==WHITE) {
                }
                else{
                    if(i==blueSentinel)
                    {
                        blueSentinel++;
                    }else{
                        int temp=nums[blueSentinel];
                        nums[blueSentinel--]=BLUE;
                        nums[i]=temp;
                        if(temp==RED&&blueSentinel!=redSentinel)
                        {
                            nums[i]=nums[redSentinel];
                            nums[redSentinel++]=RED;
                        }else if(temp==BLUE)
                        {
                            temp=nums[blueSentinel];
                            nums[blueSentinel--]=BLUE;
                            nums[i]=temp;
                            if(temp==RED)
                            {
                                temp=nums[redSentinel];
                                nums[redSentinel++]=RED;
                                nums[i]=temp;
                            }
                        }
                    }
                }
                i++;


            }
        }
    }
}
