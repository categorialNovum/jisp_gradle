package TestUtils;

import com.jisp.datatypes.CharVal;
import com.jisp.datatypes.NumVal;
import com.jisp.datatypes.StrVal;

public class TestConstants {
    public static final String additionOnly = "(+ 1 2 3 4 5)";
    public static final String subtractionOnly = "(- 5 2 3 )"; //intentional trailing space
    public static final String nested1 = "(+ 1 5 (- 4 3))";
    public static final CharVal closeParen = new CharVal(")");
    public static final CharVal openParen = new CharVal("(");
    /** is StrVal the correct token type for +,-,*,/ ? */
    public static final StrVal plusSign = new StrVal("+");
    public static final StrVal minusSign = new StrVal("-");
    public static final NumVal one = new NumVal(1);
    public static final NumVal two = new NumVal(2);
    public static final NumVal three = new NumVal(3);
    public static final NumVal four = new NumVal(4);
    public static final NumVal five = new NumVal(5);
    public static final String defineAddition = "(define (add x y) (+ x y))";
}
