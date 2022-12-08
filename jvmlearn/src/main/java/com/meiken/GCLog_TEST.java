package com.meiken;

/**
 * Created by Enzo Cotter on 2022/12/8.
 */
public class GCLog_TEST {

    public static void main(String[] args) {
        while(true){
            User user = new User();
            user.id = 1;
            user.name = "HHH";
        }


    }

    static class User{
        int id;
        String name;

    }
}
