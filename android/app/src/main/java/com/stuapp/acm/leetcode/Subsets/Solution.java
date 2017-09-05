package com.stuapp.acm.leetcode.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {



    static void dfs(List<Integer> paths,int[] nums,List<List<Integer>> ans)
    {
        //初始化
        if(paths.size()==0)
        {
            for(int i=0;i<nums.length;i++)
            {
                paths.add(nums[i]);
                dfs(paths,nums,ans);
                //将1层结点加入
                List<Integer> cur=new ArrayList<>();
                cur.add(nums[i]);
                ans.add(cur);
                paths.remove(paths.size()-1);

            }
        }else{
            int number=paths.get(paths.size()-1);
            int j=0;
            while(j<nums.length)
            {
                if(nums[j]>number)
                {
                    paths.add(nums[j]);
                    dfs(paths,nums,ans);
                    List<Integer> cur=new ArrayList<>();
                    for(int i=0;i<paths.size();i++)
                        cur.add(paths.get(i));
                    ans.add(cur);
                    paths.remove(paths.size()-1);
                }
                j++;
            }


        }
    }

    //已经保证输入数组互不重复
    public List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> ans=new ArrayList<>();

        Arrays.sort(nums);
        if(nums.length>1)
        {
            dfs(new ArrayList<Integer>(),nums,ans);
        }else{
            List<Integer> cur=new ArrayList<>();
            cur.add(nums[0]);
            ans.add(cur);
        }
        ans.add(new ArrayList<Integer>());
        return ans;
    }
}
