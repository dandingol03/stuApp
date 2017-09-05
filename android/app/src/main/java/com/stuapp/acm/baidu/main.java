package com.stuapp.acm.baidu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {




    private static int[] arr;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            List<Integer> hats=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                if(hats.size()==0)
                    hats.add(arr[i]);
                else{
                    int number=arr[i];
                    if(number<hats.get(0))
                        hats.add(0,number);
                    else{
                        int j=0;
                        while(j<hats.size()&&number>hats.get(j))
                        {
                            j++;
                        }
                        if(j<hats.size())
                        {
                            if(hats.get(j)==number)
                            {}
                            else{
                                hats.add(j,number);
                            }
                        }else{
                            hats.add(number);
                        }

                    }
                }
            }

            if(hats.size()>=3)
                System.out.println(hats.get(2));
            else
                System.out.println(-1);


        }
    }
}
