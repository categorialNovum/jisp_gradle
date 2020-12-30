package com.jisp.environment;

import com.jisp.parser.Tokenizer.Tokenizer;
import com.jisp.parser.Tokens.Token;

import java.util.ArrayList;

public class StandardEnvironment {

    // ADDITION
    public static Object add(Object a, Object b){
        return add(a,b);}

    public static Integer add(Integer a, Integer b){return a + b;}

    public static Double add(Double a, Integer b){return a + b;}

    public static Double add(Integer a, Double b){return a + b;}

    public static Double add(Double a, Double b){return a + b;}

    // SUBTRACTION
    public static Object subtract(Object a, Object b){
        return subtract(a,b);}
    public static Integer subtract(Integer a, Integer b){return a - b;}

    public static Double subtract(Double a, Integer b){return a - b;}

    public static Double subtract(Integer a, Double b){return a - b;}

    public static Double subtract(Double a, Double b){return a - b;}

    // MULTIPLICATION
    public static Integer multiply(Integer a, Integer b){return a * b;}

    public static Double multiply(Double a, Integer b){return a * b;}

    public static Double multiply(Integer a, Double b){return a * b;}

    public static Double multiply(Double a, Double b){return a * b;}

    // DIVISION
    public static Integer divide(Integer a, Integer b){return a / b;}

    public static Double divide(Double a, Integer b){return a / b;}

    public static Double divide(Integer a, Double b){return a / b;}

    public static Double divide(Double a, Double b){return a / b;}

    // GREATER THAN
    public static Boolean gt(Integer a, Integer b){return a > b;}

    public static Boolean gt(Double a, Integer b){return a > b;}

    public static Boolean gt(Integer a, Double b){return a > b;}

    public static Boolean gt(Double a, Double b){return a > b;}

    // LESS THAN
    public static Boolean lt(Integer a, Integer b){return a < b;}

    public static Boolean lt(Double a, Integer b){return a < b;}

    public static Boolean lt(Integer a, Double b){return a < b;}

    public static Boolean lt(Double a, Double b){return a < b;}

    // GREATER THAN EQUAL TO
    public static Boolean gte(Integer a, Integer b){return a >= b;}

    public static Boolean gte(Double a, Integer b){return a >= b;}

    public static Boolean gte(Integer a, Double b){return a >= b;}

    public static Boolean gte(Double a, Double b){return a >= b;}

    // LESS THAN EQUAL TO
    public static Boolean lte(Integer a, Integer b){return a <= b;}

    public static Boolean lte(Double a, Integer b){return a <= b;}

    public static Boolean lte(Integer a, Double b){return a <= b;}

    public static Boolean lte(Double a, Double b){return a <= b;}

    // EQUAL TO
    public static Boolean eq(Integer a, Integer b){return a == b;}

    // todo : should doubles w no decimal place be equal to integer?  Should (= 11 11.0) -> true/false ? Defaulting to FALSE
    public static Boolean eq(Double a, Integer b){return Boolean.FALSE;}
    public static Boolean eq(Integer a, Double b){return Boolean.FALSE;}

    public static Boolean eq(Double a, Double b){return a == b;}

    // ABSOLUTE VALUE
    public static Integer abs(Integer i){return Math.abs(i);}

    public static Double abs(Double d){return Math.abs(d);}

    // ROUND - round a double to the closest integer
    public static Integer round(Double d){return new Integer((int)Math.round(d));}

    // MAX - cast all numbers to double, perform comparisons double vs double, but return the native object type using the index of the original list
    public static Object max(ArrayList l){
        if (l.size() <= 1) {
            return l;
        }
        Double max = (Double)l.get(0);
        Integer maxIdx = 0;
        Integer idx = 0;
        for (Object o : l){
            Double next = (Double) o;
            if (next > max){
                max = next;
                maxIdx = idx;
            }
            idx++;
        }
        return l.get(maxIdx);
    }

    // MIN - cast all numbers to double, perform comparisons double vs double, but return the native object type using the index of the original list
    public static Object min(ArrayList l){
        if (l.size() <= 1) {
            return l;
        }
        Double min = (Double)l.get(0);
        Integer minIdx = 0;
        Integer idx = 0;
        for (Object o : l){
            Double next = (Double) o;
            if (next < min){
                min = next;
                minIdx = idx;
            }
            idx++;
        }
        return l.get(minIdx);
    }

    // LIST PREDICATE - list?
    public static Boolean list_p(Object o){
        System.out.println("Object Type : " + o.getClass().toString());
        return (o instanceof ArrayList);
    }

    public static Boolean not(Boolean b){return !b;}

    // CAR - first element - nondestructive
    public static Token car(ArrayList<Token> list){
        return list.get(0);
    }

    // CDR - all but first element, like 'rest' - nondestructive
    public static ArrayList<Token> cdr(ArrayList<Token> l){
        int len = l.size();
        if (len <= 1){
            return new ArrayList<Token>();
        }
        //return (ArrayList<Token>)l.remove(0);
        return l;
    }

    // CONS - add 'a' as the first object in a list along with the contents of 'b'
    public static ArrayList<Object> cons(ArrayList a, ArrayList b){
        ArrayList<Object> out = b;
        b.add(0, a);
        return b;
    }

    // LENGTH - size of a list
    public static Integer length(ArrayList l){return l.size();}

    // NULL? - null predicate
    public static Boolean null_p(Object o){
        return (o == null);
    }

    // NUMBER? - number predicate - is object a number?
    public static Boolean number_p(Object o){
        if ((o instanceof Integer) || (o instanceof Double)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static void main (String[] args){
        StandardEnvironment env = new StandardEnvironment();
        ArrayList<Token> list = new ArrayList<Token>();
        Tokenizer t = new Tokenizer();
        String codeStr = t.codeString;
        ArrayList<Token> tokens = t.tokenize(codeStr);
        Integer i = 44;
        Double d = 17.896;
        Object nl = null;
        Integer ni = null;
        String jibberish = "YourMotherWasAHamsterABCDkljdfsdafjklasdfljk(&*(&(&(7;fajdfhs";
        Boolean isList = env.list_p(list);
        System.out.println("IsList? : " + list.toString() + " -> " + env.list_p(list));
        System.out.println("IsList? : " + i.toString() + " -> " + env.list_p(i));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") + I(" + i.toString() + ") :  -> " + env.add(i,i));
        System.out.println("I(" + i.toString() + ") + D(" + d.toString() + ") :  -> " + env.add(i, d));
        System.out.println("D(" + d.toString() + ") + I(" + i.toString() + ") :  -> " + env.add(d, i));
        System.out.println("D(" + d.toString() + ") + D(" + d.toString() + ") :  -> " + env.add(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") - I(" + i.toString() + ") :  -> " + env.subtract(i, i));
        System.out.println("I(" + i.toString() + ") - D(" + d.toString() + ") :  -> " + env.subtract(i, d));
        System.out.println("D(" + d.toString() + ") - I(" + i.toString() + ") :  -> " + env.subtract(d, i));
        System.out.println("D(" + d.toString() + ") - D(" + d.toString() + ") :  -> " + env.subtract(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") * I(" + i.toString() + ") :  -> " + env.multiply(i, i));
        System.out.println("I(" + i.toString() + ") * D(" + d.toString() + ") :  -> " + env.multiply(i, d));
        System.out.println("D(" + d.toString() + ") * I(" + i.toString() + ") :  -> " + env.multiply(d, i));
        System.out.println("D(" + d.toString() + ") * D(" + d.toString() + ") :  -> " + env.multiply(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") / I(" + i.toString() + ") :  -> " + env.divide(i, i));
        System.out.println("I(" + i.toString() + ") / D(" + d.toString() + ") :  -> " + env.divide(i, d));
        System.out.println("D(" + d.toString() + ") / I(" + i.toString() + ") :  -> " + env.divide(d, i));
        System.out.println("D(" + d.toString() + ") / D(" + d.toString() + ") :  -> " + env.divide(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") > I(" + i.toString() + ") :  -> " + env.gt(i, i));
        System.out.println("I(" + i.toString() + ") > D(" + d.toString() + ") :  -> " + env.gt(i, d));
        System.out.println("D(" + d.toString() + ") > I(" + i.toString() + ") :  -> " + env.gt(d, i));
        System.out.println("D(" + d.toString() + ") > D(" + d.toString() + ") :  -> " + env.gt(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") >= I(" + i.toString() + ") :  -> " + env.gte(i, i));
        System.out.println("I(" + i.toString() + ") >= D(" + d.toString() + ") :  -> " + env.gte(i, d));
        System.out.println("D(" + d.toString() + ") >= I(" + i.toString() + ") :  -> " + env.gte(d, i));
        System.out.println("D(" + d.toString() + ") >= D(" + d.toString() + ") :  -> " + env.gte(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") < I(" + i.toString() + ") :  -> " + env.lt(i, i));
        System.out.println("I(" + i.toString() + ") < D(" + d.toString() + ") :  -> " + env.lt(i, d));
        System.out.println("D(" + d.toString() + ") < I(" + i.toString() + ") :  -> " + env.lt(d, i));
        System.out.println("D(" + d.toString() + ") < D(" + d.toString() + ") :  -> " + env.lt(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") <= I(" + i.toString() + ") :  -> " + env.lte(i, i));
        System.out.println("I(" + i.toString() + ") <= D(" + d.toString() + ") :  -> " + env.lte(i, d));
        System.out.println("D(" + d.toString() + ") <= I(" + i.toString() + ") :  -> " + env.lte(d, i));
        System.out.println("D(" + d.toString() + ") <= D(" + d.toString() + ") :  -> " + env.lte(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") == I(" + i.toString() + ") :  -> " + env.eq(i, i));
        System.out.println("I(" + i.toString() + ") == D(" + d.toString() + ") :  -> " + env.eq(i, d));
        System.out.println("D(" + d.toString() + ") == I(" + i.toString() + ") :  -> " + env.eq(d, i));
        System.out.println("D(" + d.toString() + ") == D(" + d.toString() + ") :  -> " + env.eq(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Round (" + d.toString() + ") :  -> " + env.round(d));
        System.out.println("Round (199.499) :  -> " + env.round(199.499));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("NI( )  number? :  -> " + env.number_p(ni));
        System.out.println("I(" + i.toString() + ")  number? :  -> " + env.number_p(i));
        System.out.println("D(" + d.toString() + ")  number? :  -> " + env.number_p(d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("NL()  null? :  -> " + env.null_p(nl));
        System.out.println("NI()  null? :  -> " + env.null_p(ni));
        System.out.println("I(" + i.toString() + ")  null? :  -> " + env.null_p(i));
        System.out.println("D(" + d.toString() + ")  null? :  -> " + env.null_p(d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(codeStr);
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Length (tokens) : '" + codeStr + "' :  -> " + env.length(tokens));
        System.out.println("-------------------------------------------------------------------------------------");
        for (Token tok : tokens){
            System.out.println(tok.toString());
        }
    }
}
