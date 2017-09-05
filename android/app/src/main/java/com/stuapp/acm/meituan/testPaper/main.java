package com.stuapp.acm.meituan.testPaper;


import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            boolean passed=false;
            int n=sc.nextInt();
            int[] inputs=new int[n];

            Integer biggest=Integer.MIN_VALUE;
            Integer bigger=Integer.MIN_VALUE;
            Integer normal=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                inputs[i]=sc.nextInt();
                if(inputs[i]>biggest)
                    biggest=inputs[i];
                else if(inputs[i]>bigger)
                    bigger=inputs[i];
                else if(inputs[i]>normal)
                    normal=inputs[i];
            }

            if(n==1)
            {
                System.out.println("No");
            }else if(n==2)
            {
                if(inputs[0]==inputs[1])
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }else{
                if(bigger+normal>=biggest)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }

        }
    }
}
