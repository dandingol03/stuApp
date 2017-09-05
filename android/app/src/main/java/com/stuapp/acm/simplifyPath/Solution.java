package com.stuapp.acm.simplifyPath;


import java.util.Stack;

public class Solution {

    private Stack<String> stack;

    public String normalize(String path)
    {
        int i=0;
        while(i<path.length())
        {
            char item=path.charAt(i);
            if(item=='/')
            {
                int j=i+1;
                while(j<path.length()&&path.charAt(j)!='/')
                {
                    j++;
                }
                String word=path.substring(i+1,j);
                switch (word)
                {
                    case ".":
                        break;
                    case "..":
                        if(!stack.isEmpty())
                        {
                            stack.pop();
                        }
                        break;
                    case "":
                        break;
                    default:
                        stack.push(word);
                        break;
                }

                //调整步进值
                i=j;
            }else{
                i++;
            }
        }

        String result="";
        if(stack.size()>0)
        {
            while(!stack.isEmpty())
            {
                if(result.equals(""))
                    result=stack.pop()+result;
                else
                    result=stack.pop()+"/"+result;
            }
        }
        return result;
    }

    public String simplifyPath(String path) {

        String result="";
        stack=new Stack<>();
        if(path!=null&&!path.equals(""))
        {
            if(path.equals("/"))
                return "/";
            else{
                return "/"+normalize(path);
            }
        }
        return  result;
    }
}
