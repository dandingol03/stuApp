package com.stuapp.acm.ali.runFast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Main {

    private static boolean compare(String a,String b)
    {
        if(a.equals(b))
            return false;
        else if(a.equals("2"))
            return true;
        else if(a.equals("1")&&!b.equals("2"))
            return true;
        else if(!a.equals("2")&&!a.equals("1")&&a.compareTo(b)>0)
            return  true;
        else
            return false;

    }

    private static HashMap<String, Integer> equalsPair(String cards)
    {
        HashMap<String,Integer> cardMaps=new HashMap<>();
        for(int i=0;i<cards.length();i++)
        {
            String c=cards.substring(i,i+1);
            if(cardMaps.containsKey(c))
                cardMaps.put(c,cardMaps.get(c)+1);
            else
                cardMaps.put(c,1);
        }


        return cardMaps;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String ownCards=sc.nextLine();
            String previous=sc.nextLine();


            if(previous.length()==4)
            {
                HashMap<String,Integer> maps=equalsPair(previous);
                //炸弹
                if(maps.keySet().size()==1)
                {

                }else{
                    if(maps.keySet().size()==2)
                    {
                        Iterator iterator= maps.entrySet().iterator();
                        boolean isThree=false;
                        boolean isTwo=false;
                        while (iterator.hasNext())
                        {
                            Map.Entry entry= (Map.Entry)  iterator.next();
                            Integer count=(Integer) entry.getValue();
                            if(count==1)
                                isThree=true;
                            if(count==2)
                                isTwo=true;
                        }
                        //三带一
                        if(isThree)
                        {

                        }else if(isTwo){
                            //连对
                            //todo:抽取出相同个数的对,并且出牌最大数大于上家的牌

                        }else{

                        }

                    }


                }
            }else if(previous.length()==5)
            {
                //顺子
            }
            else if(previous.length()==2)
            {
                //对子
            }
            else if(previous.length()==1)
            {
                //单牌
            }else{
                //连对
                //抽取出相同个数的对,并且出牌最大数大于上家的牌
                HashMap<String,Integer> maps=equalsPair(previous);
                //找出最大的键
                Iterator iterator=maps.keySet().iterator();
                int max=0;
                while(iterator.hasNext())
                {
                    Integer card=(Integer) iterator.next();
                    if(card>max)
                        max=card;
                }
                //todo:凑连对,达成连对的准则  =>  计数为偶数的个数总和/2>=上家对数   其中包含的最大数大于上家
                HashMap<String,Integer> ownMaps=equalsPair(ownCards);
                Iterator ownIterator=ownMaps.entrySet().iterator();
                int sum=0;
                String ownMax="3";
                while ((ownIterator.hasNext()))
                {
                    Map.Entry entry=(Map.Entry)ownIterator.next();
                    String cardNumber=(String)entry.getKey();
                    Integer cardCount=(Integer) entry.getValue();
                    if(cardCount%2==0)
                        sum+=cardCount;
                    //todo:比较2个单牌的大小
                    if(compare(cardNumber,ownMax))
                        ownMax=cardNumber;
                }



            }

        }
    }
}
