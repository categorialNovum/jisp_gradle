package com.jisp.environment;

import com.jisp.parser.Tokens.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
    StandardEnvironment stdEnv;
    private enum Expression{VAR,NUMBER,QUOTE,CONDITIONAL,DEFINITION,PROCEDURE_CALL}
    //HashMap<String,Expression> fullEnv;
    HashMap<String,Object> fullEnv;
    HashMap<String,Object> userEnv;
    HashMap<String,Method> methodEnv;

    public Environment(){
        stdEnv = new StandardEnvironment();
        fullEnv = new HashMap<String,Object>();
        userEnv = new HashMap<String,Object>();
        methodEnv = new HashMap<String,Method>();
        try {
            //fullEnv.put("+", "PLUS");
//            methodEnv.put("+", StandardEnvironment.class.getMethod("add"));
            methodEnv.put("+", StandardEnvironment.class.getMethod("add", Object.class, Object.class));
            methodEnv.put("-", StandardEnvironment.class.getMethod("subtract", Object.class, Object.class));
            /*methodEnv.put("=", StandardEnvironment.class.getMethod("eq"));
            methodEnv.put("eq?", StandardEnvironment.class.getMethod("eq"));
            methodEnv.put("+", StandardEnvironment.class.getMethod("add", Double.class, Integer.class));
            methodEnv.put("+", StandardEnvironment.class.getMethod("add", Double.class, Double.class));
            methodEnv.put("-", StandardEnvironment.class.getMethod("subtract"));
            methodEnv.put("*", StandardEnvironment.class.getMethod("multiply"));
            methodEnv.put("/", StandardEnvironment.class.getMethod("divide"));
            methodEnv.put(">", StandardEnvironment.class.getMethod("gt"));
            methodEnv.put(">=", StandardEnvironment.class.getMethod("gte"));
            methodEnv.put("<", StandardEnvironment.class.getMethod("lt"));
            methodEnv.put("<=", StandardEnvironment.class.getMethod("lte"));
            methodEnv.put("not", StandardEnvironment.class.getMethod("not"));
            methodEnv.put("abs", StandardEnvironment.class.getMethod("abs"));
            methodEnv.put("max", StandardEnvironment.class.getMethod("max"));
            methodEnv.put("min", StandardEnvironment.class.getMethod("min"));
            methodEnv.put("car", StandardEnvironment.class.getMethod("car"));
            methodEnv.put("cdr", StandardEnvironment.class.getMethod("cdr"));
            methodEnv.put("cons", StandardEnvironment.class.getMethod("cons"));
            methodEnv.put("append", StandardEnvironment.class.getMethod("cons"));
            methodEnv.put("length", StandardEnvironment.class.getMethod("length"));
            methodEnv.put("list", StandardEnvironment.class.getMethod("list"));
            methodEnv.put("list?", StandardEnvironment.class.getMethod("list_p"));
            methodEnv.put("number?", StandardEnvironment.class.getMethod("number_p"));
            methodEnv.put("symbol?", StandardEnvironment.class.getMethod("symbol_p"));
            methodEnv.put("procedure?", StandardEnvironment.class.getMethod("procedure_p"));*/
//            for (Method m : methodEnv.values()){
 //               System.out.println("METHOD ENV : " + m.toString());
  //          }
        }catch (NoSuchMethodException ex){
            System.out.println("No such method, assface.");
            System.out.println(ex.toString());
        }
    }

    public Object eval(Object list){
        System.out.println("EVAL --> " + list.toString());
        if (list instanceof Symbol){
            System.out.println("EVAL - SYMBOL - " + list.toString());
            ArrayList alist = (ArrayList)list;
            System.out.println("list size : " + alist.size());
            return methodEnv.get(list.toString());
        }else if(! (list instanceof ArrayList)){
            System.out.println("EVAL - NOT ArrayList - " + list.toString());
            return list;
        }
        /*else if(list instanceof ArrayList){
            System.out.println("EVAL - ArrayList - " + list.toString());
            ArrayList<Object> lst = (ArrayList<Object>)list;
            Token t = (Token)lst.remove(0);
            if (t instanceof Quote){
                System.out.println("EVAL - QUOTE - " + list.toString());
                return lst.remove(0);
            }else if(t instanceof Conditional){
                System.out.println("EVAL - CONDITIONAL - " + list.toString());
                Object test = lst.remove(0);
                Object consequence = lst.remove(0);
                Object alternative = lst.remove(0);
            }else if (t instanceof Define){
                System.out.println("EVAL - DEFINE - " + list.toString());
                String var = lst.get(0).toString();
                ArrayList exp = (ArrayList)lst.get(0);
                fullEnv.put(var,eval(exp));
            }
        }*/
        return list;
    }

    public Object evalList(ArrayList<Object> l){
        System.out.println("EVAL --> " + l.toString());
        Object o = l.remove(0); // Pop
            if (l.size() == 0) {
                return null;
            }
            if (o instanceof Symbol) {
                Symbol s = (Symbol)o;
                System.out.println("EVAL - symbol - " + s.toString());
                System.out.println("symbol - list size " + l.size());
                if (s.getIsStdOp()){
                    System.out.println("STANDARD OP SYMBOL : " + s.toString());
                    return methodEnv.get(o);
                }
                return userEnv.get(o);
            } else if (!(o instanceof ArrayList)) {
                System.out.println("EVAL - NOT ArrayList - " + o.toString());
                return o;
            } else if (o instanceof ArrayList) {
                System.out.println("EVAL - ArrayList - " + o.toString());
                ArrayList<Object> lst = (ArrayList<Object>) o;
                Token t = (Token) lst.remove(0);
                /*if (t instanceof Quote) {
                    System.out.println("EVAL - QUOTE - " + o.toString());
                    return lst.remove(0);
                } else if (t instanceof Conditional) {
                    System.out.println("EVAL - CONDITIONAL - " + o.toString());
                    Object test = lst.remove(0);
                    Object consequence = lst.remove(0);
                    Object alternative = lst.remove(0);
                } else if (t instanceof Define) {
                    System.out.println("EVAL - DEFINE - " + o.toString());
                    String var = lst.get(0).toString();
                    ArrayList exp = (ArrayList) lst.get(0);
                    userEnv.put(var, evalList(exp));
                }*/
            }
        return o;
    }
    /*public Object evalList(ArrayList<Object> l){
        if (l.size() == 0){return null;}
        System.out.println("EVAL --> " + l.toString());
        Object o = l.remove(0); // Pop
        if (o instanceof Symbol){
            System.out.println("EVAL - symbol - " + o.toString());
            return fullEnv.get(o);
        }else if(! (o instanceof ArrayList)){
            System.out.println("EVAL - NOT ArrayList - " + o.toString());
            return o;
        }else if(o instanceof ArrayList){
            System.out.println("EVAL - ArrayList - " + o.toString());
            ArrayList<Object> lst = (ArrayList<Object>)o;
            Token t = (Token)lst.remove(0);
            if (t instanceof Quote){
                System.out.println("EVAL - QUOTE - " + o.toString());
                return lst.remove(0);
            }else if(t instanceof Conditional){
                System.out.println("EVAL - CONDITIONAL - " + o.toString());
                Object test = lst.remove(0);
                Object consequence = lst.remove(0);
                Object alternative = lst.remove(0);
            }else if (t instanceof Define){
                System.out.println("EVAL - DEFINE - " + o.toString());
                String var = lst.get(0).toString();
                ArrayList exp = (ArrayList)lst.get(0);
                fullEnv.put(var,eval(exp));
            }
        }
        return o;
    }*/
}
