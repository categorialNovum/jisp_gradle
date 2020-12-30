package com.jisp.datatypes;

public class Pair extends Value{

    static Value car, cdr;

    Pair(Value a, Value b){
        car = a;
        cdr = b;
    }

    public static Value car(){
        return car;
    }

    public static Value cdr(){
        return cdr;
    }

    public static void setCar(Value v){
       car = v;
    }

    public static void setCdr(Value v){
        cdr = v;
    }

    public String write(){
        String returnStr = car.write();
        if (cdr instanceof Pair){
            returnStr += cdr.write();
        }else if (cdr instanceof NilVal){
            return returnStr;
        }
        returnStr += " . ";
        returnStr += cdr.write();
        return returnStr;
    }

    public Pair getVal(){
        //return new Pair(car,cdr);
        return this;
    }
}
