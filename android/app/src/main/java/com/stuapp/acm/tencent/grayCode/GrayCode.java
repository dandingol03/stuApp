package com.stuapp.acm.tencent.grayCode;


import java.util.ArrayList;
import java.util.List;

public class GrayCode {


    String[] ans;

    //迭代格雷码
    private void getNext(String prev,int number)
    {
        try{
            String str="";


            for(int i=prev.length()-1;i>0;i--)
            {
                char high=prev.charAt(i);
                char low=prev.charAt(i-1);
                if(high==low)
                    str="0"+str;
                else
                    str="1"+str;
            }
            str=prev.substring(0,1)+str;
            ans[number]=str;


            String next="";
            if(prev.length()==1){
                if(prev.equals("0"))
                    getNext("1",++number);

            }else{
                int r=1;
                //求下一个二进制数列
                for(int j=prev.length()-1;j>=0;j--)
                {
                    next=(Integer.valueOf(prev.substring(j,j+1))+r)%2+next;
                    if(Integer.valueOf(prev.substring(j,j+1))+r==2)
                        r=1;
                    else
                        r=0;
                }

                if(r==1)
                {}
                else
                    getNext(next,++number);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public String[] getGray(int n) {
        // write code here
        ans=new String[1<<n];
        String prev="";
        for(int i=0;i<n;i++)
            prev+="0";
        getNext(prev,0);


        return ans;
    }
}
