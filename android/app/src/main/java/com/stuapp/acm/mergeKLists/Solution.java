package com.stuapp.acm.mergeKLists;


import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Solution {

    private ArrayList<ListNode> heap=new ArrayList<>();


    private void heapify(int i)
    {
        int position=i;
        int left=position*2+1;
        int right=position*2+2;

        if(left<heap.size()&&heap.get(left).val<heap.get(position).val)
            position=left;
        if(right<heap.size()&&heap.get(right).val<heap.get(position).val)
            position=right;
        //非父结点最小
        if(position!=i)
        {
            //交换父结点和最小结点
            ListNode temp=heap.get(i);
            heap.set(i,heap.get(position));
            heap.set(position,temp);
            //交换后的子树可能不满足最小堆的原则
            heapify(position);
        }


    }

    //小根堆
    private void minHeapify()
    {

        //这的边界问题不是特别严重
        for(int i=0;i<heap.size()/2-1;i++)
        {
            heapify(i);
        }
    }

    //合并k链表
    public ListNode mergeKLists(ListNode[] lists) {
        //将多个链表的单个结点组成堆
        for(int i=0;i<lists.length;i++)
        {
            heap.add(lists[i]);
        }

        minHeapify();

        ListNode head=null;
        ListNode p=null;
        //根据最小堆形成单一有序链表
        while(heap.size()!=0)
        {

            if(head==null)
            {
                //取出最小堆的根
                head=heap.get(0);
                p=heap.get(0);
            }else{
                p.next=heap.get(0);
                p=p.next;
            }


            if(p.next!=null)
            {
                //将根结点的子结点放置在堆的根处，因为堆其它地方有序，所以只需对0处进行堆维护
                heap.set(0,p.next);
                heapify(0);
            }else{
                //当子结点为空时，该链表已排序完,重新进行对维护
                heap.remove(0);
                minHeapify();
            }
        }


        return head;
    }
}
