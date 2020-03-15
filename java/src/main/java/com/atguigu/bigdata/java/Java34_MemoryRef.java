package com.atguigu.bigdata.java;

import java.util.ArrayList;

public class Java34_MemoryRef {

    public static void main(String[] args) {
        ArrayList<User34> list = new ArrayList<User34>();

        User34 user = new User34();
        user.name = "zhangsan";

        list.add(user);

        ArrayList<User34> list1 = (ArrayList<User34>)list.clone();
        User34 user1 = list1.get(0);
        user1.name = "lisi";

        System.out.println(user.name);
        System.out.println(user1.name);
    }

}

class User34 {
    public String name;
}
