package com.stuapp.acm.tencent.characterShift;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String str=sc.nextLine();
            //先输出小写再输出大写
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)<='z'&&str.charAt(i)>='a')
                    System.out.print(str.charAt(i));
            }
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)<='Z'&&str.charAt(i)>='A')
                    System.out.print(str.charAt(i));
            }
        }
    }
}
