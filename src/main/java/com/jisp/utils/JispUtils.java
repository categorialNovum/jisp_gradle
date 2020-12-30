package com.jisp.utils;

import com.jisp.parser.Tokens.Token;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JispUtils {
    //Trailing _P denotes a predicate ; EQ? -> EQ_P
    public enum StandardOps{PLUS, GT, LT, GTE, LTE, EQ, MULTIPLY, DIVIDE, ABS, APPEND, APPLY, BEGIN, CAR, CDR, CONS, EQ_P,
        EQUAL_P, LENGTH, LIST, LIST_P, MAP, MAX, MIN, NOT, NULL_P, NUMBER_P, PROCEDURE_P, ROUND, SYMBOL_P}

    public static Boolean isStdOp(String s){
        // convert token to uppercase, convert ? to _P for predicates
        String token = s.toUpperCase().replace("?", "_P");
        for (StandardOps op : StandardOps.values()){
            if (token.equals(op.toString()));
            return Boolean.TRUE;
        }
        if (s.equals("+")
                || s.equals("-")
                || s.equals("*")
                || s.equals("/")
                || s.equals("%")
                || s.equals(">")
                || s.equals(">=")
                || s.equals("<")
                || s.equals("<=")
                || s.equals("=")){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static void printTokenStrings(ArrayList<Token> tokens){
       tokens.stream().forEach(t -> System.out.print(t.getData().write() + " "));
       System.out.print("\n");
    }
}
