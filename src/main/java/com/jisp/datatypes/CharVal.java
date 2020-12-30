package com.jisp.datatypes;

public class CharVal extends Value{
    Character data;

    public CharVal(String s){
        data = s.charAt(0);
    }

    public String write(){
        return data.toString();
    }

    public Character getVal(){
        return data;
    }
}
