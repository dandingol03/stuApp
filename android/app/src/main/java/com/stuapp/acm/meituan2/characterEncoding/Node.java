package com.stuapp.acm.meituan2.characterEncoding;


public class Node {

    Node left;
    Node right;

    String c;

    int frequency=0;
    public Node() {
        this.left=null;
        this.right=null;
    }
    public Node(int frequency)
    {
        this.frequency=frequency;
        this.left=null;
        this.right=null;
    }

    public Node(String c)
    {
        this.c=c;
        this.left=null;
        this.right=null;
    }
}
