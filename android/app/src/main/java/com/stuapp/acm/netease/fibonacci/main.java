package com.stuapp.acm.netease.fibonacci;

import java.util.Scanner;

public class main {



    public static void main(String[] args)
    {



            int number=19;
            int f0=0;
            int f1=1;
            while(true)
            {
                if(number>=f0&&number<=f1)
                {
                    System.out.println(Math.min(Math.abs(f0-number),Math.abs(f1-number)));
                    break;
                }else{
                    int temp=f1;
                    f1=f0+f1;
                    f0=temp;
                }
            }


    }
}
