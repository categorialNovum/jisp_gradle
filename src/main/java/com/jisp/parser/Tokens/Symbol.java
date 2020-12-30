package com.jisp.parser.Tokens;

import com.jisp.datatypes.StrVal;
import com.jisp.datatypes.Value;
import com.jisp.utils.JispUtils;

public class Symbol extends Token{
    //private String data;
    private StrVal data;
    private Boolean isStdOp;

    public Symbol(String s){
        setData(s);
        isStdOp = JispUtils.isStdOp(s);
    }

    public void setData(String s){
        data = new StrVal(s);
    }

    public Boolean getIsStdOp(){return isStdOp;}

    public String getTypeStr(){
        return TokenType.SYMBOL.toString();
    }

    public TokenType getType(){
        return TokenType.SYMBOL;
    }

    public String toString(){
        return data.toString();
    }

    public Value getData(){
        return data;
    }
}
