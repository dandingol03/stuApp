package com.stuapp.acm.multiplyStrings;


public class Solution {

    private String add(String longer,String shorter)
    {
        String result="";
        int flag=0;
        int j=longer.length()-1;
        for(int i=shorter.length()-1;i>=0;i--)
        {
            int digit=Integer.valueOf(shorter.substring(i,i+1));
            int added=Integer.valueOf(longer.substring(j,j+1));
            result=(digit+added+flag)%10+result;
            if(digit+added+flag>=10)
                flag=1;
            else
                flag=0;
            j--;
        }

        if(j!=-1)
        {
            for(int k=j;k>=0;k--)
            {
                int digit=Integer.valueOf(longer.substring(k,k+1));
                result=(digit+flag)%10+result;
                if(digit+flag>=10)
                    flag=1;
                else
                    flag=0;
            }
        }

        if(flag==1)
            result=1+result;

        return result;
    }

    private String calculateSum(String num1,String num2)
    {
        if(num1.length()>=num2.length())
        {
            return add(num1,num2);
        }else{
            return add(num2,num1);
        }
    }

    private String calculate(String longer,String shorter)
    {
        String sum="";
        String offset="";

        int flag=0;
        for(int i=shorter.length()-1;i>=0;i--)
        {

            String result="";
            flag=0;
            int digit=Integer.valueOf(shorter.substring(i,i+1));
            for(int j=longer.length()-1;j>=0;j--)
            {
                int multified=Integer.valueOf(longer.substring(j,j+1));
                result=(multified*digit+flag)%10+result;
                if(digit*multified+flag>=10)
                    flag=(digit*multified+flag)/10;
                else
                    flag=0;
            }
            //todo:进行2个字符串的求和

            sum=calculateSum((flag==0?"":flag)+""+result+offset,sum);
            offset+="0";
        }




        return sum;
    }

    public String multiply(String num1, String num2) {

        if(num1!=null&&num2!=null)
        {
            if(num1.equals("0")||num2.equals("0"))
                return "0";
            if(num1.equals(""))
                return num2;
            else if(num2.equals(""))
                return  num1;
            else {
                if(num1.length()>=num2.length())
                    return  calculate(num1,num2);
                else
                    return  calculate(num2,num1);
            }
        }

        return null;
    }
}
