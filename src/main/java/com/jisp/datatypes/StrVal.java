package com.jisp.datatypes;

public class StrVal extends Value{
    String data;

    public StrVal(String s){
        data = s;
    }

    public String write(){
        return data;
    }
    public String getVal(){
       return data;
    }
}
