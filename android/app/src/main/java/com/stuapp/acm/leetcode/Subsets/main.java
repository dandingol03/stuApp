package com.stuapp.acm.leetcode.Subsets;

import java.util.List;

public class main {
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        List<List<Integer>> ans= solution.subsets(new int[]{0});
        System.out.println(ans);
    }
}
