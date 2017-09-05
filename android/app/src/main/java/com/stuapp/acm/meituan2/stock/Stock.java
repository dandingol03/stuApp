package com.stuapp.acm.meituan2.stock;


import java.util.ArrayList;

public class Stock {

    private static ArrayList<Integer> profits=new ArrayList<>();

    public int maxProfit(int[] prices, int n) {


        int min=prices[0];
        int dis=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<prices[i-1])//遇到了更低的价格,此时应该买进
            {
                if(dis!=0)
                    profits.add(dis);
                min=prices[i];
                dis=0;
            }else{
                if(prices[i]-min>dis)
                    dis=prices[i]-min;
            }
        }
        if(dis!=0)
            profits.add(dis);

        //todo:遍历profits链表
        int biggest=profits.get(0);
        int bigger=Integer.MIN_VALUE;

        for(int i=1;i<profits.size();i++)
        {
            if(profits.get(i)>biggest)
            {
                bigger=biggest;
                biggest=profits.get(i);
            }
            else if(profits.get(i)>bigger)
                bigger=profits.get(i);

        }


        if(bigger!=Integer.MIN_VALUE)
            return bigger+biggest;
        else
            return biggest;
    }
}
