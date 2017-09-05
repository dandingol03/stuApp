package com.stuapp.acm.leetcode.Combinations;

import java.util.ArrayList;
import java.util.List;



public class Solution {

    static List<List<Integer>> ans=new ArrayList<>();


    //返回下一个比它大的数,这里有明显的结果遍历规则，采用dfs进行尝试
    static void dfs(int n,int k,List<Integer> paths)
    {
        if(paths.size()==k)
        {
            List<Integer> cur=new ArrayList<>();
            for(int i=0;i<paths.size();i++)
                cur.add(paths.get(i));
            ans.add(cur);
        }
        else{
            if(paths.size()==0)
            {
                for(int i=1;i<=n;i++)
                {
                    if(paths.contains(i))
                    {}
                    else{
                        paths.add(i);
                        dfs(n,k,paths);
                        paths.remove(paths.size()-1);
                    }
                }
            }else{
                int number=paths.get(paths.size()-1);
                for(int i=number+1;i<=n;i++)
                {
                    if(paths.contains(i))
                    {}
                    else{
                        paths.add(i);
                        dfs(n,k,paths);
                        paths.remove(paths.size()-1);
                    }
                }
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k, new ArrayList<Integer>());
        return ans;
    }
}
