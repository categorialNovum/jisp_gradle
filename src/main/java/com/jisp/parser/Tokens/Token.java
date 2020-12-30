package com.jisp.parser.Tokens;

import com.jisp.datatypes.Value;

public  abstract class Token <T>{
    public enum TokenType {NUMBER, SYMBOL, OPEN_PAREN, CLOSE_PAREN, QUOTE, CONDITIONAL,DEFINE,NIL}

    Value val;

    /*
    public String toString(){
        return val.toString();
    }
     */
    public String toString(){return val.write();}

    public abstract String getTypeStr();

    public abstract TokenType getType();

    public abstract Value getData();
}
