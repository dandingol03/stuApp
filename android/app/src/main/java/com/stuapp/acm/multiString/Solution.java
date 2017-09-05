package com.stuapp.acm.multiString;



public class Solution {
    public String multiply(String num1, String num2) {

        String total="0";
        for(int i=num1.length()-1;i>=0;i--)
        {
            String result="0";
            int flag=0;
            int remain=0;
            int multipier=Integer.parseInt(num1.substring(i,i+1));
            for(int j=0;j<num2.length();j++)
            {
                int num=Integer.parseInt(num2.substring(j,j+1));
                if(num*multipier+flag>=10)
                {
                    flag=(num*multipier)/10;
                    remain=(num*multipier+flag)%10;
                }else{
                    flag=0;
                }
                result=Integer.valueOf(result)*10+String.valueOf(remain);
            }
            if(flag!=0)
                result=Integer.valueOf(result)*10+String.valueOf(flag);
            total=Integer.valueOf(total)*10+result;

        }

        return total;
    }
}
