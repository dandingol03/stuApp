package com.stuapp.acm.meituan2.characterEncoding;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class main {



    private static LinkedList<CharKey> charSet=new LinkedList<>();
    private static HashMap<String,Integer> charMaps=new HashMap<>();


    private static void resortList(int index)
    {
        if(index==charSet.size())
        {
        }else{
            boolean isSorted=false;
            CharKey charKey=charSet.get(index);
            for(int i=index+1;i<charSet.size();i++)
            {
                if(charSet.get(i).frequency>charSet.get(index).frequency)//进行插入
                {
                    if(i!=index)
                    {
                        charSet.add(i,charKey);
                        charSet.remove(index);
                    }
                    isSorted=true;
                    break;
                }
            }

            if(!isSorted)
            {
                charSet.add(charKey);
                charSet.remove(index);
            }


        }
    }

    private static void  previousTraverse(Node t)
    {
        if(t.c!=null)
        {
            charMaps.put(t.c,t.frequency);
        }
        if(t.left!=null)
            previousTraverse(t.left);
        if(t.right!=null)
            previousTraverse(t.right);

    }


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String s=sc.nextLine();


            for(int i=0;i<s.length();i++)
            {
                String c=s.substring(i,i+1);
                boolean isExist=false;
                for(int j=0;j<charSet.size();j++)
                {
                    CharKey key=charSet.get(j);
                    if(key.c==c)
                    {
                        isExist=true;
                        key.frequency++;
                        //对于charSet进行重排
                        resortList(j);
                    }
                }
                if(isExist==false)
                {
                    charSet.add(new CharKey(c));
                }
            }

            //生成haffman树
            while(charSet.size()>=2)
            {
                CharKey key1=charSet.get(0);
                CharKey key2=charSet.get(1);

                Node node=new Node(key1.frequency+key2.frequency);
                Node leftNode=new Node(key1.c);
                Node rightNode=new Node(key2.c);
                node.left=leftNode;
                node.right=rightNode;
                CharKey newKey=new CharKey(node);
                charSet.add(0,newKey);
                resortList(0);
            }

            //获得各个字符的编码
            CharKey rootKey=charSet.get(0);
            //todo:前序遍历
            previousTraverse(rootKey.root);

        }
    }
}
