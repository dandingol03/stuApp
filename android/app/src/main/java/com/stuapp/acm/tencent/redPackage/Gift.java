package com.stuapp.acm.tencent.redPackage;


import java.util.HashMap;

public class Gift {

    HashMap<Integer,Integer> keys=new HashMap<>();

    public int getValue(int[] gifts, int n) {

        for(int i=0;i<gifts.length;i++)
        {
            if(keys.containsKey(gifts[i]))
            {
                int number=keys.get(gifts[i])+1;
                if(number>n/2)
                    return gifts[i];
                keys.put(gifts[i],number);
            }
            else
                keys.put(gifts[i],1);

        }


        return 0;
    }
}
