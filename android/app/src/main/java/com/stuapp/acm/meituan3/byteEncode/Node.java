package com.stuapp.acm.meituan3.byteEncode;


public class Node {
    int weight;
    int pathWeight;
    char value;
    Node left;
    Node right;
    Node(){
        this.left=null;
        this.right=null;
    }
    Node(char value)
    {
        this.left=null;
        this.right=null;
        this.weight=1;
        this.value=value;//该属性不是必要
        this.pathWeight=1;
    }
}
