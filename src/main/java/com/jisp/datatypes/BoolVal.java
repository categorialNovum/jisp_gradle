package com.jisp.datatypes;

public class BoolVal extends Value{
    String data;
    BoolVal(Boolean b){
        if (b){
            data = "#t";
        }else{
            data = "#f";
        }
    }
    public String getVal(){return data;}

    public String write(){return data;}
}
