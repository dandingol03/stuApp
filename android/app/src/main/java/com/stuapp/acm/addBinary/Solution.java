package com.stuapp.acm.addBinary;


public class Solution {

    private String calculate(String longer,String shorter)
    {
        int flag=0;
        int j=longer.length()-1;
        String result="";
        for(int i=shorter.length()-1;i>=0;i--)
        {
            int digit=Integer.valueOf(shorter.substring(i,i+1));
            int added=Integer.valueOf(longer.substring(j,j+1));
            if(i==shorter.length()-1)
            {
                if(digit+added>=2)
                    flag=1;
                result=(digit+added)%2+result;

            }else{
                result=(digit+added+flag)%2+result;
                if(digit+added+flag>=2)
                    flag=1;
                else
                    flag=0;
            }
            j--;
        }
        if(j!=-1)
        {
            //遍历完longer
            for(int z=j;z>=0;z--)
            {
                int added=Integer.valueOf(longer.substring(z,z+1));
                result=(added+flag)%2+result;
                if(flag+added>=2)
                    flag=1;
                else
                    flag=0;
            }

        }

        if(flag==1)
            result=1+result;


        return result;
    }

    public String addBinary(String a, String b) {

        if(a!=null&&b!=null)
        {
            if(a.equals(""))
                return b;
            else if(b.equals(""))
                return a;
            else{
                if(a.length()>=b.length())
                {
                    return calculate(a,b);
                }else{
                    return calculate(b,a);
                }
            }
        }

        return null;
    }
}
