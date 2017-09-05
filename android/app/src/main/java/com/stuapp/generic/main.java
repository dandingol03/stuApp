package com.stuapp.generic;


import java.lang.reflect.Field;

import static android.R.id.list;

public class main {

    static class Node<T extends  String>{
        public T value;
    }

    public static void main(String[] args)
    {
        Node<String> node=new Node<>();
        node.value="danding";
        Class clazz=node.getClass();
        try{
            Field field=clazz.getDeclaredField("value");
            System.out.println(field);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
