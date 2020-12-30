package com.jisp.parser.Tokens;

import com.jisp.datatypes.CharVal;
import com.jisp.exceptions.TokenException;

public class Quote extends Token{
    CharVal data;

    public Quote(String s) {
        try {
            if (s.toUpperCase().equals("QUOTE") || s.equals("'")) {
                setData(s);
            }else {
                throw new TokenException();
            }

        } catch (TokenException ex) {
            System.out.println("Exception while parsing QUOTE : " + ex.toString());
        }
    }

    public void setData(String s) {
        data = new CharVal(s);
    }

    public String getTypeStr() {
        return TokenType.QUOTE.toString();
    }

    public TokenType getType() {
        return TokenType.QUOTE;
    }

    public String toString() {
        return data.toString();
    }

    public CharVal getData(){
        return data;
    }
}
