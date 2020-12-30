package com.jisp.parser;

import com.jisp.parser.Tokens.Token;

import java.util.ArrayList;

public class Parser {

    public Parser() {
    }

    public static Object parse(ArrayList<Token> tokens) {
        if (tokens.size() == 0) {
                //throw new SyntaxException("Empty List -> Unbalanced Expression.");
                System.out.println("Empty List -> Unbalanced Expression.");
        }
        Token token = tokens.remove(0); // POP and assign
        if (token.getType() == Token.TokenType.OPEN_PAREN) {
            ArrayList expr = new ArrayList<Object>();
            while (tokens.size() >=1 && tokens.get(0).getType() != Token.TokenType.CLOSE_PAREN) {
                //System.out.println("Token (while) -> " + token.toString());
                expr.add(parse(tokens));
            }
            tokens.remove(0); // POP only
            return expr;
        } else if (token.getType() == Token.TokenType.CLOSE_PAREN) {
            System.out.println("# INCORRECTLY NESTED CLOSE PAREN 8----> " + token.toString());
        }
            //System.out.println("***** ATOMIC SYMBOL / NUMBER -->  [" + token.toString() + "]");
        return token;
    }
}
