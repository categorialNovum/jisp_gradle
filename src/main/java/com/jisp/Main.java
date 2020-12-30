package com.jisp;

import com.jisp.environment.Environment;
import com.jisp.environment.StandardEnvironment;
import com.jisp.parser.Parser;
import com.jisp.parser.Tokenizer.Tokenizer;
import com.jisp.parser.Tokens.Token;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    private static Environment env;

    public static void init(){
        env = new Environment();
    }

    public static void main(String[] args) {
       init();
	    if (args.length < 1){
            System.out.println("Requires a JiSP file as input. Exiting");
            System.exit(0);
        }
        try {
            FileReader input = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(input);
            String line = "";
            Tokenizer t = new Tokenizer();
            Parser p = new Parser();
//            t.test();
            while (reader.ready()){
                line = reader.readLine();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("LINE : " + line);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                ArrayList<Token> tokens = t.tokenize(line);
                System.out.println("TOKENIZED : " + tokens);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                ArrayList<Object> parsed = (ArrayList<Object>)p.parse(tokens);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("PARSED (" + parsed.size() + ") : " + parsed);

                for(Object o : parsed){
                    System.out.println("% : " + o.toString() + " : " + o.getClass().toString());
                }
                System.out.println("------------------------------------");
                System.out.println("EVALUATE");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                Object value = env.eval(parsed);
                Object value2 = env.evalList(parsed);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("VALUE : " + value2);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("--> Finished <--");
            Method method = StandardEnvironment.class.getMethod("add", Integer.class, Integer.class);
            Method genericMethod = StandardEnvironment.class.getMethod("add", Object.class, Object.class);
            // regular call
            System.out.println("METHOD INVOCATION : " + method.invoke(StandardEnvironment.class, 123, 456));
            // call to static method can use null for first param
            System.out.println("METHOD INVOCATION : " + method.invoke(null, 123, 456));
//            System.out.println("GENERIC METHOD INVOCATION : " + genericMethod.invoke(null, 123, 456));
        }catch (FileNotFoundException ex){
            System.out.println("JiSP file not found. exiting");
            System.out.println(ex.toString());
        }catch (IOException ex){
            System.out.println("IO exception");
            System.out.println(ex.toString());
        }catch (NoSuchMethodException ex){
            System.out.println("No Such Method exception");
            System.out.println(ex.toString());
        }catch (IllegalAccessException ex){
            System.out.println("Illegal Access exception");
            System.out.println(ex.toString());
        }catch (InvocationTargetException ex){
            System.out.println("Invocation Target exception");
            ex.printStackTrace();

        }
    }
}
