package com.stuapp.acm.meituan2.characterEncoding;


public class CharKey {
    String c;
    int frequency=1;
    Node root;

    public CharKey(String c) {
        this.c = c;
    }

    public CharKey(Node root) {
        this.root=root;
        this.frequency=root.frequency;
    }
}
