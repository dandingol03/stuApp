package com.stuapp.acm.didi.restaurant;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static android.R.attr.y;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] desks=new int[n];
            for(int i=0;i<n;i++)
                desks[i]=sc.nextInt();
            Group[] customers=new Group[m];
            for(int i=0;i<m;i++)
            {
                customers[i]=new Group(sc.nextInt(),sc.nextInt());
            }


            Arrays.sort(customers, new Comparator<Group>() {
                @Override
                public int compare(Group lhs, Group rhs) {
                    return lhs.cost-rhs.cost;
                }
            });

            //记录已经安排的桌子
            List<Integer> arranged=new ArrayList<>();

            //应该是升序
            for(int j=customers.length-1;j>=0;j--)
            {

            }

        }
    }
}
