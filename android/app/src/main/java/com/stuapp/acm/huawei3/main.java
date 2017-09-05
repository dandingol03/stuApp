package com.stuapp.acm.huawei3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class main {

    private static String search(String arg1,String arg2)
    {
        if(arg1.contains(arg2))
        {
            int start=arg1.indexOf(arg2);
            return arg1.substring(start);
        }else{
            return "";
        }
    }

    private static String quote(String arg1)
    {

        return arg1;
    }

    private static String reverse(String arg1)
    {
        String tmp="";
        for(int i=arg1.length()-1;i>=0;i--)
            tmp+=arg1.charAt(i);
        return tmp;
    }

    private static String combine(Stack<String> args)
    {
        String tmp="";
        while(!args.empty())
        {
            tmp=args.pop()+tmp;
        }
        return tmp;
    }

    //参数都为字符串
    private static String computeStatement(String statement)
    {
        String lastResult=null;
        Stack<String> stack=new Stack<>();
        int i=0;
        while(i<statement.length())
        {
            char cur= statement.charAt(i);
            if(statement.charAt(i)!=' ')
            {
                if(cur=='(')
                {
                    stack.push("(");
                    i++;
                }
                else if(cur=='"')
                {
                    int j=i+1;
                    while(j<statement.length())
                    {
                        if(statement.charAt(j)=='"')
                            break;
                        else
                            j++;
                    }
                    String tmp=statement.substring(i+1,j);
                    stack.push(tmp);
                    i=j+1;
                }else if(cur==')'){

                    Stack<String> arguments=new Stack<>();
                    String argument=stack.pop();
                    while(!argument.equals("combine")&&!argument.equals("search")&&!argument.equals("reverse")&&!argument.equals("quote"))
                    {
                        arguments.add(argument);
                        argument=stack.pop();
                    }
                    //操作符是最后进去的
                    String op=argument;
                    String result=null;
                    switch (op)
                    {
                        case "combine":
                            result=combine(arguments);
                            break;
                        case "search":

                            result=search(arguments.get(1),arguments.get(0));
                            break;
                        case "reverse":
                            result=reverse(arguments.get(0));
                            break;
                        case "quote":
                            result=quote(arguments.get(0));
                            break;
                    }
                    stack.pop();
                    if(stack.empty())
                    {
                        lastResult=result;
                    }else{
                        stack.push(result);
                    }
                    i++;
                }else{
                    //遇到op字符
                    int j=i+1;
                    while(j<statement.length())
                    {
                        if(statement.charAt(j)==' ')
                            break;
                        else
                            j++;
                    }
                    String tmp=statement.substring(i,j);
                    stack.push(tmp);
                    i=j;
                }

            }else{
                i++;
            }
        }


        return "\""+lastResult+"\"";
    }

    public static void main(String []args)
    {

        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(computeStatement(str));
    }
}
