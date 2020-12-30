package com.jisp.parser.Tokens;

import com.jisp.datatypes.NumVal;
import com.jisp.datatypes.Value;

public class IntNum extends Token{
    //Integer data;
    NumVal data;
    public IntNum(String s){
        setData(s);
    }

    public void setData(String s){
        data = new NumVal(Integer.parseInt(s));
    }

    public String toString(){
        return data.toString();
    }

    public Double toDouble(){
        return new Double(data.getData());
    }

    public Integer toInt(){
        return data.getData();
    }

    public String getTypeStr(){
        return TokenType.NUMBER.toString();
    }

    public TokenType getType(){
        return TokenType.NUMBER;
    }

    public Value getData(){
        return data;
    }
}
