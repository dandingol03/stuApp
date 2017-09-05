package com.stuapp.acm.huawei2;

import java.util.Scanner;

/**
 * Created by danding on 17/6/28.
 */

public class main {
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String[] items=str.split(" ");

        String total="";

        for(int i=items.length-1;i>=0;i--)
        {
            String word=items[i];
            if(word.equals(""))
            {
            }else{
                total+=word+" ";
            }
        }
        if(total.length()>0)
        {
            total=total.substring(0,total.length()-1);
        }

        System.out.println(total);

    }
}
