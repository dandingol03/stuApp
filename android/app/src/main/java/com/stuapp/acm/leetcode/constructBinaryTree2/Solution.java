package com.stuapp.acm.leetcode.constructBinaryTree2;



public class Solution {

    private TreeNode recurse(int[] postorder, int[] inorder, int postLow, int postHigh, int inLow, int inHigh)
    {
        TreeNode t=new TreeNode(postorder[postHigh]);

        if(postHigh==postLow)//叶结点
        {
            return t;
        }

        //左子树元素个数
        int leftLen=0;
        //右子树元素个数
        int rightLen=0;


        //搜索中序遍历数组
        for(int i=inLow;i<=inHigh;i++)
        {
            if(inorder[i]==postorder[postHigh])//后序遍历父结点位于最后
            {
                leftLen=i-inLow;
                rightLen=inHigh-i;
                break;
            }
        }


        //具有左子树
        if(leftLen>0)
        {
            t.left=recurse(postorder,inorder,postLow,postLow+leftLen-1,inLow,inLow+leftLen-1);
        }

        //具有右子树
        if(rightLen>0)
            t.right=recurse(postorder,inorder,postHigh-rightLen,postHigh-1,inHigh-rightLen+1,inHigh);


        return t;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root=null;
        if(postorder!=null&&postorder.length>0&&inorder!=null&&inorder.length>0)
        {
            //进行二叉树的构建
            root=recurse(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
        }


        return root;
    }
}
