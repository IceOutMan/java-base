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
            // 可以用来做一些校验
            if(name == null || age == null){
                throw new IllegalArgumentException("name or age is null");
            }
            
            meikenConfig.content = name + " : " + age;
            return meikenConfig;
        }
    }
}
