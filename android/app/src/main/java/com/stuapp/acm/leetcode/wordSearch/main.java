package com.stuapp.acm.leetcode.wordSearch;


public class main {
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        char[][] board=new char[3][];
        board[0]=new char[]{'A','B','C','E'};
        board[1]=new char[]{'S','F','C','S'};
        board[2]=new char[]{'A','D','E','E'};
        boolean re= solution.exist(board,"ABCCED");
        System.out.println(re);
    }

}
