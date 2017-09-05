package com.stuapp.acm.nowcoder.chorus;


import java.util.HashMap;
import java.util.Scanner;

/**
 * 处理输入输出
 */
public class main {



    public static void main(String[] args)
    {

        HashMap<String,String > materials=new HashMap<>();

        Scanner in=new Scanner(System.in);
        while(in.hasNext())
        {
            String str=in.nextLine();
            String[] items=str.split(" ");
            for(int i=0;i<items.length;i++)
            {
                String materialName=items[i];
                if(materials.get(materialName)!=null)
                {
                }else{
                    materials.put(materialName,materialName);
                }
            }
            str=in.nextLine();
        }
        System.out.println(materials.size());
    }
}
