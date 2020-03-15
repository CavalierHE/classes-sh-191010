package com.atguigu.bigdata.java;

public class Java29_Method {
    public static void main(String[] args) throws Exception {
        User29 user1 = new User29();
        user1.id = 1;

        User29 user2 = new User29();
        user2.id = 1;

        System.out.println(user1.equals(user2));

        Class<? extends User29> aClass = user2.getClass();
        Class<User29> bClass = User29.class;
        System.out.println(aClass == bClass);
    }
}


class User29 {
    public int id = 0;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User29){
            User29 other = (User29)obj;
            return this.id == other.id;
        }else {
            return false;
        }
    }
}



