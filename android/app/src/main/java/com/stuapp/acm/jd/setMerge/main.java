package com.stuapp.acm.jd.setMerge;


import java.util.Arrays;
import java.util.Scanner;

public class main {





    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int []a=new int[n];
            int []b=new int[m];

            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            for(int i=0;i<m;i++)
                b[i]=sc.nextInt();

            Arrays.sort(a);
            Arrays.sort(b);


            int i=0;
            int j=0;



            Integer previous=null;
            while (i<a.length&&j<b.length)
            {

                int smaller=a[i]<=b[j]?a[i]:b[j];
                int way=a[i]<=b[j]?0:1;

                if(previous!=null)
                {
                    if(smaller==previous)
                    {
                        if(way==0)
                            i++;
                        else
                            j++;
                    }
                    else{
                        System.out.print(smaller);
                        if(way==0&&i!=a.length-1)
                            System.out.print(" ");
                        if(way==1&&j!=b.length-1)
                            System.out.print(" ");

                        previous=smaller;
                        if(way==0)
                            i++;
                        else
                            j++;
                    }
                }else{
                    previous=smaller;
                    System.out.print(smaller);
                    if(way==0&&i!=a.length-1)
                        System.out.print(" ");
                    if(way==1&&j!=b.length-1)
                        System.out.print(" ");
                    if(way==0)
                        i++;
                    else
                        j++;
                }
            }

            if(i<a.length)
            {
                System.out.print(" ");
                for(int k=i;k<a.length;k++)
                {
                    System.out.print(a[k]);
                    if(k!=a.length-1)
                        System.out.print(" ");
                }
            }

            if(j<b.length)
            {
                System.out.print(" ");
                for(int k=j;k<b.length;k++)
                {
                    System.out.print(b[k]);
                    if(k!=b.length-1)
                        System.out.print(" ");
                }
            }


        }
    }
}
