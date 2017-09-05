package com.stuapp.acm.plusOne;



import java.util.Iterator;
import java.util.LinkedList;


public class Solution {
    public int[] plusOne(int[] digits) {

        LinkedList<Integer> results=new LinkedList<>();


        if(digits!=null&&digits.length>0)
        {
            //最高位位于数组的最前端
            int flag=0;
            for(int i=digits.length-1;i>=0;i--)
            {
                int number=digits[i];
                if(i==digits.length-1)
                {
                    if(number+1==10)
                        flag=1;
                    results.add(0,(number+1)%10);
                }else{
                    results.add(0,(number+flag)%10);
                    if(flag+number==10)
                        flag=1;
                    else
                        flag=0;
                }
            }
            if(flag==1)
                results.add(0,1);
        }else{
        }

        //todo:遍历链表,将链表转换为数组
        Iterator<Integer> iterator=results.iterator();
        int[] res=new int[results.size()];
        int i=0;
        while(iterator.hasNext())
        {
            res[i++]=iterator.next();
        }


        return res;
    }
}
