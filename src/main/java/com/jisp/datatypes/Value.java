package com.jisp.datatypes;

public abstract class Value {
    public enum ValueType {NUMBER, SYMBOL, OPEN_PAREN, CLOSE_PAREN, QUOTE, CONDITIONAL,DEFINE,NIL}

    public abstract String write();

    //public abstract Object getVal(){return new Object();}
    public abstract Object getVal();

}
