package com.meiken;

public class MeikenConfig {

    private String content ;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    static class Builder{

        private String name;
        private Integer age;

        Builder name(String name){
            this.name = name;
           return this;
        }

        Builder age(Integer age){
            this.age = age;
            return this;
        }


        MeikenConfig build(){
            MeikenConfig meikenConfig = new MeikenConfig();
            meikenConfig.content = name + " : " + age;
            return meikenConfig;
        }
    }
}
