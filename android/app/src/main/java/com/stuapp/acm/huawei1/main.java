package com.stuapp.acm.huawei1;


import java.util.Scanner;

import static android.view.View.Z;

public class main {
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String[] items=str.split(" ");
        int numberC=0;
        int characterC=0;
        int otherC=0;

        for(int i=0;i<items.length;i++)
        {
            String word=items[i];
            boolean numberFlag=false;
            boolean characterFlag=false;
            boolean otherFlag=false;
            if(word.equals(""))
            {
                numberFlag=false;
                characterFlag=false;
                otherFlag=false;
            }else{
                for(int j=0;j<word.length();j++)
                {
                    char tmp=word.charAt(j);
                    boolean flag=false;
                    if(word.charAt(j)>='0'&&word.charAt(j)<='9'&&numberFlag==false)
                    {
                        numberC++;
                        numberFlag=true;
                        characterFlag=false;
                        otherFlag=false;
                    }
                    else if((word.charAt(j)>='A'&&word.charAt(j)<='z')&&characterFlag==false)
                    {
                        characterC++;
                        characterFlag=true;
                        numberFlag=false;
                        otherFlag=false;

                    }else if(otherFlag==false&&(word.charAt(j)<'0'||word.charAt(j)>'9')&&(word.charAt(j)<'A'||word.charAt(j)>'z'))
                    {
                        otherC++;
                        otherFlag=true;
                        numberFlag=false;
                        characterFlag=false;
                    }else{
                    }

                }
            }
        }


        //输出结果
        System.out.println(characterC+","+numberC+","+otherC);
    }
}
