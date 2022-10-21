package dev.pia.weekfive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
    2. Using assertTrue() and assertFalse(), write some tests. Remember the naming
    conventions for tests: testFunctionName_Condition.
 */

@RunWith(Parameterized.class)
public class BalancedBracketsTest {

    BalancedBrackets balanced = new BalancedBrackets();

    private String input;
    private boolean expected;

    public BalancedBracketsTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> testConditions() {

        String startClosedParens = "),(";
        String emptyString = "";
        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<()>";
        String mismatchedBrackets = "<({)}>";
        String tooManyClosingOpenBrackets = "()))))";

        Object[][] expected = {
            { startClosedParens, false },
            { emptyString, true },
            { balancedAngleBrackets, true },
            { balancedComboBrackets, true },
            { mismatchedBrackets, false },
            { tooManyClosingOpenBrackets, false }
        };

        return Arrays.asList(expected);
    }

    @Test
    public void testBalancedBrackets() {
        assertEquals(expected, balanced.balanceBrackets(input));
    }

    // @Test
    // public void testBalancedBrackets_EmptyString() {
    //     assertTrue(balanced.balanceBrackets(emptyString));
    // }

    // @Test
    // public void testBalancedBrackets_BalancedAngleBrackets() {
    //     assertTrue(balanced.balanceBrackets(balancedAngleBrackets));
    // }

    // @Test
    // public void testBalancedBrackets_BalancedComboBrackets() {
    //     assertTrue(balanced.balanceBrackets(balancedComboBrackets));
    // }

    // @Test 
    // public void testBalancedBrackets_MismatchedBrackets() {
    //     assertFalse(balanced.balanceBrackets(mismatchedBrackets));
    // }

    // @Test 
    // public void testBalancedBrackets_TooManyClosingOpenBrackets() {
    //     assertFalse(balanced.balanceBrackets(tooManyClosingOpenBrackets));
    // }
}
