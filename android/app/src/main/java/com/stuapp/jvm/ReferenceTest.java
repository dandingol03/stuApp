package com.stuapp.jvm;




import java.lang.ref.SoftReference;

public class ReferenceTest {

    static class A{
        String name;

        public A(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args)
    {
        A a = new A("danding");
        SoftReference<A> srfA=new SoftReference<A>(a);
        System.gc();

        if(srfA.get()==null)
        {
        }
        else{
            System.out.println("a对象尚未被回收");
        }





    }
}
