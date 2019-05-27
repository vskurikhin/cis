package su.svn.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracesTest
{
    String test01 = "([](){([])})";
    @Test
    void testCase01()
    {
        boolean result = (new BalanceChecker(test01)).check();
        assertTrue(result);
    }

    String test02 = test01 + System.lineSeparator();
    @Test
    void testCase02()
    {
        boolean result = (new BalanceChecker(test02)).check();
        assertTrue(result);
    }

    String test03 = "()[]}";
    @Test
    void testCase03()
    {
        BalanceChecker balance;
        boolean result = (balance = new BalanceChecker(test03)).check();
        assertFalse(result);
        assertEquals(5, balance.getPosition());
    }

    String test04 = "{{[()]]";
    @Test
    void testCase04()
    {
        BalanceChecker balance;
        boolean result = (balance = new BalanceChecker(test04)).check();
        assertFalse(result);
        assertEquals(7, balance.getPosition());
    }

    String test05 = "([]";
    @Test
    void testCase05()
    {
        BalanceChecker balance;
        boolean result = (balance = new BalanceChecker(test05)).check();
        assertFalse(result);
        assertEquals(1, balance.getPosition());
    }

    String test06 = "(()";
    @Test
    void testCase06()
    {
        BalanceChecker balance;
        boolean result = (balance = new BalanceChecker(test06)).check();
        assertFalse(result);
        assertEquals(1, balance.getPosition());
    }

    String test07 = "(((((((((((((((()))";
    @Test
    void testCase07()
    {
        BalanceChecker balance;
        boolean result = (balance = new BalanceChecker(test07)).check();
        assertFalse(result);
        assertEquals(13, balance.getPosition());
    }
}