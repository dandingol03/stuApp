package com.stuapp.acm.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class Solution {

    public class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }




    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<>();
        if(intervals==null||intervals.size()==0)
        {}
        else{
            Collections.sort(intervals,new MyComparator());

            int end=1;
            for(int i=0;i<intervals.size();i++)
            {
                Interval interval=intervals.get(i);
                if(result.size()==0)
                {
                    end=interval.end;
                    result.add(interval);
                }else{
                    if(interval.start>end){
                        result.add(interval);
                        end=interval.end;
                    }else{
                        Interval last=result.get(result.size()-1);
                        //新的interval包含于results的尾部
                        if(interval.end<=last.end)
                        {
                        }else{
                            last.end=interval.end;
                            end=interval.end;
                        }
                    }
                }
            }

        }

        return result;
    }
}
