package com.stuapp.acm.jumpGame;


public class Solution {




    //贪心算法
    public int jump(int[] nums) {


        int res = 0, i = 0, cur = 0;
        while (cur < nums.length - 1) {
            int pre = cur;
            while (i <= pre) {
                cur = Math.max(cur, i + nums[i]);
                ++i;
            }
            ++res;
            if (pre == cur) return -1; // May not need this
        }
        return res;
    }
}
