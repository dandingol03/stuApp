package com.stuapp.inherit.staticBlock;



public class Son extends Father{
    static {
        System.out.println("son static block");
    }
    Son(){
        super();
    }
}
