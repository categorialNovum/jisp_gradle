package com.jisp.datatypes;

//NIL or Empty List value
public class NilVal extends Value{
    String data;
    NilVal(){
        data = "nil";
    }

    public String write() {
        return data.toString();
    }

    public String getData(){return data;}

    public String getVal(){return data;}

}
