package Components;

import TestUtils.TestConstants;
import com.jisp.parser.Parser;
import com.jisp.parser.Tokenizer.Tokenizer;
import com.jisp.parser.Tokens.Symbol;
import com.jisp.parser.Tokens.Token;
import com.jisp.utils.JispUtils;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParserTest {

    private Tokenizer tokenizer = new Tokenizer();
    private Parser parser = new Parser();

    @Test
    /** (+ 1 2 3 4 5) **/
    public void test01_ParseAdditionOnly(){
        ArrayList<Token> tokens = tokenizer.tokenize(TestConstants.additionOnly);
        // 8 tokens including parens
        assertEquals(8, tokens.size());
        JispUtils.printTokenStrings(tokens);
        Object parseResult = parser.parse(tokens);
        ArrayList<Object> prCast = (ArrayList<Object>) parseResult;
        // 6 items with parens removed after parse
        assertEquals(6, prCast.size());
    }

    @Test
    /** (+ 1 5 (- 4 3)) **/
    public void test03_ParseNested(){
        ArrayList<Token> tokens = tokenizer.tokenize(TestConstants.nested1);
        assertEquals(10, tokens.size());
        JispUtils.printTokenStrings(tokens);
        Object parseResult = parser.parse(tokens);
        ArrayList<Object> prCast = (ArrayList<Object>) parseResult;
        // 3 leading tokens and a nested ArrayList in the last spot
        assertEquals(4, prCast.size());
        assertEquals(ArrayList.class, prCast.get(3).getClass());
    }

    @Test
    /** (define (add x y) (+ x y)) **/
    public void test04_DefineAdditon(){
        Object parseResult = parser.parse(tokenizer.tokenize(TestConstants.defineAddition));
        ArrayList<Object> prCast = (ArrayList<Object>) parseResult;
        assertEquals(3, prCast.size());
        assertEquals(Symbol.class, prCast.get(0).getClass());
        Symbol define = (Symbol)prCast.get(0);
        assertTrue(define.getIsStdOp());
        assertEquals(ArrayList.class, prCast.get(1).getClass());
        assertEquals(ArrayList.class, prCast.get(2).getClass());
    }
}
