package com.atguigu.bigdata.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Java14_List {
    public static void main(String[] args) throws Exception {

        // List Set Map
        // TODO List : LinkedList, ArrayList

        // 增加数据的时候，哪一个集合速度块？
        // 1. 容量够，向末尾增加数据 : ArrayList
        // Node
        // 2. 容量够，但是向中间增加数据 : LinkedList

        // 3. 容量不够，增加数据：LinkedList

        // 查询数据的时候，哪一个集合速度快？
        // 1. 数据库中取50条，web页面展示出来 ： 没有区别，线性查找
        // 2. 查询指定位置的数据:ArrayList

        List list = new ArrayList(50);
        for ( int i = 1; i <= 50; i++ ) {
            list.add("123123");
        }

        // TODO Map : HashMap, Hashtable
        // 1. 极限情况下，HashMap放多少条数据可以将链表转换为红黑二叉树？
        // 8 + 1 + 1 + 1 = 11条

        // 2. 16 => 32 => 64, 扩容为什么是2倍
        // 为了保证hashmap底层数组的每个空间可以合理利用，必须保证容量为2的N次方
        //  hash(key.hashCode) & (16 - 1)
        //

        // TODO Set : HashSet TreeSet
        HashSet set = new HashSet(); // HashMap (无序，数据不可重复)
        set.add("123");

    }

}



