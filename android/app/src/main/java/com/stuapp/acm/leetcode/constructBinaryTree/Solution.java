package com.stuapp.acm.leetcode.constructBinaryTree;


/**
 * 从前序和中序中生成整个二叉树
 * 1>.还是更改为4个参数的逻辑吧
 */

public class Solution {

    private TreeNode  recurse(int[] preorder,int[] inorder,int preLow,int preHigh,int inLow,int inHigh)
    {
        TreeNode t=new TreeNode(preorder[preLow]);

        if(preLow==preHigh)//叶结点
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
            if(inorder[i]==preorder[preLow])
            {
                leftLen=i-inLow;
                rightLen=inHigh-i;
                break;
            }
        }

        //具有左子树
        if(leftLen>0)
        {
            t.left=recurse(preorder,inorder,preLow+1,preLow+leftLen,inLow,inLow+leftLen-1);
        }

        //具有右子树
        if(rightLen>0)
            t.right=recurse(preorder,inorder,preHigh-rightLen+1,preHigh,inHigh-rightLen+1,inHigh);

        return t;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root=null;
        if(preorder!=null&&preorder.length>0&&inorder!=null&&inorder.length>0)
        {
            //进行二叉树的构建
            root=recurse(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        }


        return root;
    }
}
