package com.stuapp.acm.tencent.characterCode;


import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            String line=sc.nextLine();
            int radix0=(int)Math.pow(26,3)+3;
            int i=1;

            int byteCode=0;
            byteCode+=(line.charAt(0)-'a')*radix0;
            //根据字符长度解码遍历
            switch (line.length())
            {
                case 1:
                    byteCode++;
                    break;
                case 2:
                    byteCode=byteCode+2;
                    break;
                case 3:
                    byteCode=byteCode+3;
                    break;
                case 4:
                    for(int j=i;j<4;j++)
                    {
                        byteCode+=(line.charAt(j)-'a')*Math.pow(26,3-j);
                    }
                    break;
            }

            System.out.println(byteCode);
        }
    }
}
