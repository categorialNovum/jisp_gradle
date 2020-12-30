package com.jisp.parser.Tokens;

import com.jisp.datatypes.CharVal;
import com.jisp.exceptions.TokenException;

public class Paren extends Token{
    CharVal data;
    TokenType paren_type;
    private final Character openParenChar = '(';
    private final Character closeParenChar = ')';

    public Paren(String s) {
        try {
            setData(s);
            if (openParenChar.equals(data.getVal())) {
                paren_type = TokenType.OPEN_PAREN;
            } else if (closeParenChar.equals(data.getVal())) {
                paren_type = TokenType.CLOSE_PAREN;
            } else {
                throw new TokenException();
            }

        } catch (TokenException ex) {
            System.out.println("Exception while parsing paren : " + ex.toString());
        }
    }

    public void setData(String s) {
        data = new CharVal(s);
    }

    public CharVal getData() {
        return data;
    }

    public String getTypeStr() {
        return paren_type.toString();
    }

    public TokenType getType() {
        return paren_type;
    }

    public String toString() {
        return data.toString();
    }
}
