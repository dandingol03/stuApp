package com.stuapp.acm.leetcode.Combinations;


import java.util.List;

public class main {

    public static void main(String[] args)
    {
       Solution solution=new Solution();
       List<List<Integer>> ans=  solution.combine(4,2);
        System.out.println(ans);
    }
}
