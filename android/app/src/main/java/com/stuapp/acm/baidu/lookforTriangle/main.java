package com.stuapp.acm.baidu.lookforTriangle;


import java.util.HashMap;
import java.util.Scanner;

public class main {

    static String R="R";
    static String G="G";
    static String B="B";
    static class Point{
        String color;
        double x;
        double y;
        double z;

    }

    static boolean judgeTriangle(Point p1,Point p2,Point p3)
    {
        double edge1=Math.sqrt(Math.abs(Math.pow(p1.x,2)-Math.pow(p2.x,2))+Math.abs(Math.pow(p1.y,2)-Math.pow(p2.y,2))+
                Math.abs(Math.pow(p1.z,2)-Math.pow(p2.z,2)));
        double edge2=
        Math.sqrt(Math.abs(Math.pow(p2.x,2)-Math.pow(p3.x,2))+Math.abs(Math.pow(p2.y,2)-Math.pow(p3.y,2))+
                Math.abs(Math.pow(p2.z,2)-Math.pow(p3.z,2)));

        double edge3= Math.sqrt(Math.abs(Math.pow(p3.x,2)-Math.pow(p1.x,2))+Math.abs(Math.pow(p3.y,2)-Math.pow(p1.y,2))+
                Math.abs(Math.pow(p3.z,2)-Math.pow(p1.z,2)));
        if((edge1+edge2>edge3)&&(edge1+edge3>edge2)&&(edge2+edge3>edge1))
            return true;

        return false;
    }

    static boolean judgeColor(Point p1,Point p2,Point p3)
    {
        if(p1.color.equals(p2.color)&&p2.color.equals(p3.color))
            return true;
        if(!p1.color.equals(p2.color)&&!p2.color.equals(p3.color)&&!p3.color.equals(p1.color))
            return true;
        return false;
    }


    static double getTriangleArea(Point p1,Point p2,Point p3)
    {
        double edge1=Math.sqrt(Math.abs(Math.pow(p1.x,2)-Math.pow(p2.x,2))+Math.abs(Math.pow(p1.y,2)-Math.pow(p2.y,2))+
                Math.abs(Math.pow(p1.z,2)-Math.pow(p2.z,2)));
        Point mid=new Point();
        mid.x=(p1.x+p2.x)/2;
        mid.y=(p1.y+p2.y)/2;
        mid.z=(p1.z+p2.z)/2;
        double h=Math.sqrt(Math.abs(Math.pow(mid.x,2)-Math.pow(p3.x,2))+Math.abs(Math.pow(mid.y,2)-Math.pow(p3.y,2))+
                Math.abs(Math.pow(mid.z,2)-Math.pow(p3.z,2)));
        return edge1*h/2;
    }


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());

            Point[] arr=new Point[n];

            for(int i=0;i<n;i++)
            {
                Point point=new Point();
                point.color=sc.next();
                point.x=sc.nextInt();
                point.y=sc.nextInt();
                point.z=sc.nextInt();
                arr[i]=point;
            }

            double max=0;

            for(int i=0;i<n-2;i++)
            {
                Point p1=arr[i];
                for(int j=i+1;j<n-1;j++)
                {
                    Point p2=arr[j];
                    for(int k=j+1;k<n;k++)
                    {
                        Point p3=arr[k];
                        boolean flag=false;
                        boolean rFlag=false;
                        boolean bFlag=false;
                        boolean gFlag=false;


                        if(judgeTriangle(p1,p2,p3)&&judgeColor(p1,p2,p3))//是否能构成三角形
                        {
                            //todo:求解三角形面积
                            double s=getTriangleArea(p1,p2,p3);
                            if(s>max)
                                max=s;
                        }
                    }
                }
            }

            System.out.println(String.format("%.5f",max));

        }
    }
}
