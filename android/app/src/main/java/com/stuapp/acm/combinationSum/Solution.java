package com.stuapp.acm.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        helper(candidates, target, 0, item, res);
        return res;
    }


    private void helper(int[] candidates, int target, int start, ArrayList<Integer> item,
                        List<List<Integer>> res) {
        //当前序列已经超过
        if (target < 0)
            return;

        //该序列满足要求,返回
        if (target == 0&&!res.contains(item)) {
            res.add(new ArrayList<Integer>(item));
            return;
        }


        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1])//deal with dupicate
                continue;
            item.add(candidates[i]);
            int newtarget = target - candidates[i];
            helper(candidates, newtarget, i, item, res);//之所以不传i+1的原因是：
            //The same repeated number may be
            //chosen from C unlimited number of times.
            item.remove(item.size() - 1);
        }
    }

}
