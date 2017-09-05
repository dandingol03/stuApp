package com.stuapp.acm.netease.Interplanetary;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String t=in.nextLine();

        if(!s.equals("")&&!t.equals(""))
        {
            //维持2个指针
            int j=0;
            boolean flag=false;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)==t.charAt(j))
                {
                    j++;
                }
                if(j==t.length())
                {
                    flag=true;
                    break;
                }
            }
            if(flag)
                System.out.println("Yes");
            else
                System.out.println("No");


        }

    }
}
