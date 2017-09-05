package com.stuapp.hashmap;


import java.util.HashMap;

public class main {
    public static void main(String[] args)
    {
        HashMap<String,Integer> namemaps=new HashMap<String, Integer>();
        try{
            int re=0;
            namemaps.put("danding",1);
            re=namemaps.put("danding",1);
            System.out.println("....");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
