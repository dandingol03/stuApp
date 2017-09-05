package com.stuapp.acm.permutation;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

public class Solution {

    List<List<Integer>> result=new ArrayList<>();
    //由顺序最小到倒序最大
    public void generatePermute(int []num)
    {

        for(int i=num.length-2;i>=0;i--)
        {
            if(num[i]<num[i+1])
            {
                int min=i+1;
                int bigger=i+1;
                for(int j=i+2;j<=num.length-1;j++)
                {
                    if(num[j]<num[min])
                        min=j;
                    if(num[j]>num[i]&&num[j]<num[bigger])
                        bigger=j;
                }
                if(min==i+1)//如果i+1在最右侧
                {
                    int temp=num[i];
                    num[i]=num[i+1];
                    num[i+1]=temp;
                }else{
                    //i+1不在最右测，又因为<i,i+1>为最右顺序数，所以i+1的右侧都比num[i+!]小，所以[i+1]必须为最大数下标

                    if(num[min]<num[i])
                    {
                        if(bigger!=i+1)//恰好大的数和最小数分离
                        {
                            int temp=num[i];
                            num[i]=num[bigger];
                            num[bigger]=temp;

                            temp=num[i+1];
                            num[i+1]=num[min];
                            num[min]=temp;

                        }else{
                            int temp=num[i];
                            num[i]=num[i+1];
                            num[i+1]=temp;

                            //进行i+1和最小值的交换
                            temp=num[i+1];
                            num[i+1]=num[min];
                            num[min]=temp;
                        }


                    }else{
                        int temp=num[i];
                        num[i]=num[min];
                        num[min]=temp;

                        if(min!=i+1)
                        {
                            temp=num[i+1];
                            num[i+1]=num[min];
                            num[min]=temp;
                        }
                    }

                }
                List<Integer> serial=new ArrayList<>();
                for(int k=0;k<num.length;k++)
                    serial.add(num[k]);
                result.add(serial);
                generatePermute(num);
                break;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        //生成了从小到大的序列,并加入
        List<Integer> serial=new ArrayList<>();
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++)
            serial.add(nums[k]);
        result.add(serial);



        generatePermute(nums);


        return result;
    }
}
