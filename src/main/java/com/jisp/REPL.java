package com.jisp;

import com.jisp.datatypes.*;
import com.jisp.parser.Tokenizer.Tokenizer;
import com.jisp.parser.Tokens.Token;

import java.util.Scanner;

public class REPL {
    static Tokenizer tokenizer;

    private static void init(){
        tokenizer = new Tokenizer();
    }

    public static Token[] read(Scanner in){
        //return tokenizer.tokenize_array(in.next());
        return tokenizer.tokenize_array(in.nextLine());
    }

    public static Value eval(Token tokens[]){
        return tokens[0].getData();
    }

    public static void write(Value v){
        //System.out.println("# : " + v.getVal().toString());
        System.out.println("# : " + v.write());
    }

    public static void main(String args[]){
        System.out.println("##################################################");
        System.out.println("JiSP REPL 1.0");
        System.out.println("##################################################");

        init();
        Scanner input = new Scanner(System.in);
        // READ -> EVAL -> PRINT
        while (true){
            System.out.print("->");
            write(eval(read(input)));
        }
    }
}
