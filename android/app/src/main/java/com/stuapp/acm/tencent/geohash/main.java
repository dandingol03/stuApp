package com.stuapp.acm.tencent.geohash;


import java.util.Scanner;



public class main {

    private static String getGeocode(int low,int high,int number)
    {
        int mid=(low+high)/2;
        if(number>=low&&number<=mid)
            return "0"+getGeocode(low,mid,number);
        else
            return "1"+getGeocode(mid+1,high,number);
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int latlng=sc.nextInt();
            System.out.println(getGeocode(-90,90,latlng));
        }
    }
}
