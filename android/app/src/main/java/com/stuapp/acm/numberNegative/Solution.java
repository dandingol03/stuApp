package com.stuapp.acm.numberNegative;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by danding on 17/6/27.
 */

public class Solution {
    public int reverse(int x) {

        int flag=0;
        if(x<0)
            flag=-1;

        int temp= Math.abs(x);
        String re="";
        re+=String.valueOf(temp%10);
        while(temp>0)
        {
            temp=temp/10;
            int digit=temp%10;
            if(temp>0)
                re+=digit;
        }
        if(re.compareTo("4294967296")>=0)
            return 0;
        else
        {
            if(flag==0)
                return Integer.valueOf("2147483651");
            else
                return -Integer.valueOf(re);
        }


    }
}
