package dev.pia.weekfive;

import java.util.Stack;

/**
 * Hello world!
 *
 */
public class BalancedBrackets {
    // public static void main( String[] args ) {
    //     String str = "[((((((((())>>>>>>)))))))";
    //     boolean balanced = balanceParentheses(str);
    //     System.out.println("Are the parentheses balanced: " + balanced);
    // }

    public boolean balanceBrackets(String str) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '>') {
                if (stack.isEmpty() || stack.pop() != '<') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
