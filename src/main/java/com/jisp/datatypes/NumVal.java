package com.jisp.datatypes;

public class NumVal extends Value{
    Integer data;

    public NumVal(Integer n){
        data = n;
    }
    public NumVal(Double n){
        data = n.intValue();
    }

    public String write(){
        return data.toString();
    }

    public Integer getData(){
        return data;
    }

    public Integer getVal(){ return data; }

    public String toString(){return data.toString();}
}
