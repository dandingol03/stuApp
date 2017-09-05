package com.stuapp.acm.mergeIntervals;


import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        List<Interval> inputs=new ArrayList<>();
        inputs.add(new Interval(1,4));
        inputs.add(new Interval(0,2));
        inputs.add(new Interval(3,5));
        solution.merge(inputs);
    }
}
