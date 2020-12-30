package Components;

import TestUtils.TestConstants;
import com.jisp.parser.Tokenizer.Tokenizer;
import com.jisp.parser.Tokens.Token;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TokenizerTest{

    private Tokenizer tokenizer = new Tokenizer();

    @Ignore
    @Test
    public void test01_AdditionOnlyTest(){
        ArrayList<Token> tokens = tokenizer.tokenize(TestConstants.additionOnly);
        assertEquals(8, tokens.size());
        assertEquals(TestConstants.openParen.getVal(), tokens.get(0).getData().getVal());
        assertEquals(TestConstants.plusSign.getVal(), tokens.get(1).getData().getVal());
        assertEquals(TestConstants.five.getVal(), tokens.get(6).getData().getVal());
        assertEquals(TestConstants.closeParen.getVal(), tokens.get(7).getData().getVal());
    }

    @Ignore
    @Test
    public void test02_SubtractionOnlyTest(){
        ArrayList<Token> tokens = tokenizer.tokenize(TestConstants.subtractionOnly);
        assertEquals(6, tokens.size());
        assertEquals(TestConstants.openParen.getVal(), tokens.get(0).getData().getVal());
        assertEquals(TestConstants.minusSign.getVal(), tokens.get(1).getData().getVal());
        assertEquals(TestConstants.three.getVal(), tokens.get(4).getData().getVal());
        assertEquals(TestConstants.closeParen.getVal(), tokens.get(5).getData().getVal());
    }

    @Test
    public void test03_NestedTest(){
        ArrayList<Token> tokens = tokenizer.tokenize(TestConstants.nested1);
        assertEquals(10, tokens.size());
        assertEquals(TestConstants.openParen.getVal(), tokens.get(0).getData().getVal());
        assertEquals(TestConstants.plusSign.getVal(), tokens.get(1).getData().getVal());
        assertEquals(TestConstants.one.getVal(), tokens.get(2).getData().getVal());
        assertEquals(TestConstants.five.getVal(), tokens.get(3).getData().getVal());
        assertEquals(TestConstants.openParen.getVal(), tokens.get(4).getData().getVal());
        assertEquals(TestConstants.minusSign.getVal(), tokens.get(5).getData().getVal());
        assertEquals(TestConstants.four.getVal(), tokens.get(6).getData().getVal());
        assertEquals(TestConstants.three.getVal(), tokens.get(7).getData().getVal());
        assertEquals(TestConstants.closeParen.getVal(), tokens.get(8).getData().getVal());
        assertEquals(TestConstants.closeParen.getVal(), tokens.get(9).getData().getVal());
    }

    @Test
    public void test04_createOpenParenToken(){
       Token t1 = tokenizer.createToken("(");
       assertEquals(Token.TokenType.OPEN_PAREN, t1.getType());
    }
    @Test
    public void test05_createCloseParenToken(){
        Token t1 = tokenizer.createToken(")");
        assertEquals(Token.TokenType.CLOSE_PAREN, t1.getType());
    }
    @Test
    public void test06_createNumberToken(){
        Token t1 = tokenizer.createToken("123");
        assertEquals(Token.TokenType.NUMBER, t1.getType());
    }
    @Test
    public void test07_createSymbolToken(){
        Token t1 = tokenizer.createToken("abcdefg");
        assertEquals(Token.TokenType.SYMBOL, t1.getType());
    }
}
