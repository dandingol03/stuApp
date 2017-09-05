package com.stuapp.acm.netease.paradomine;


import java.util.Scanner;

public class main {

    static String a;
    static String b;

    private static boolean isParadomine(StringBuilder str)
    {
        int i=0;
        int j=str.length()-1;

        boolean flag=true;
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                flag=false;
                break;
            }
            i++;
            j--;
        }

        return flag;
    }

    private static int paradomine()
    {
        int methods=0;
        for(int i=0;i<=a.length();i++)
        {
            StringBuilder sb=new StringBuilder();
            if(i==0)
            {
                sb.append(b);
                sb.append(a);
                if(isParadomine(sb))
                {
                    methods++;
                }

            }else if(i==a.length())
            {
                sb.append(a.substring(0,i));
                sb.append(b);
                if(isParadomine(sb))
                {
                    methods++;
                }
            }
            else{
                sb.append(a.substring(0,i));
                sb.append(b);

                sb.append(a.substring(i));
                if(isParadomine(sb))
                {
                    methods++;
                }
            }
        }
        return methods;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            a = scan.nextLine();
            b = scan.nextLine();
            System.out.println(paradomine());
        }
        scan.close();



    }
}
