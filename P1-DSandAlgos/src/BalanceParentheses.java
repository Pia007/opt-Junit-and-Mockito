import java.util.Stack;

public class BalanceParentheses {

    /*
        Write a function that takes in a string and returns true or false depending
        on whether that string has balanced parentheses. A string has balanced
        parantheses if every opening paranthesis “(“ has a matching closing
        paranthesis “)” that closes the corresponding opening paranthesis.
        
        For the purposes of this problem, you only need to worry about parentheses
        “(“and “)”, not other opening-and-closing marks, like curly brackets, square
        brackets, or angle brackets.
    */ 

    public static void main(String[] args) {

        String str = "(((((((())))))))";
        boolean balanced = balanceParentheses(str);
        System.out.println("Are the parentheses balanced: " + balanced);

        String str2 = "(((((((())))";
        boolean balanced2 = balanceParentheses(str2);
        System.out.println("Are the parentheses balanced: " + balanced2);

        String str3 = "[((((((((())>>>>>>)))))))";
        boolean balanced3 = balanceBrackets(str3);
        System.out.println("Are the brackets balanced: " + balanced3);

        String str4 = "[)]";
        boolean balanced4 = balanceStackBrackets(str4);
        System.out.println("Are the brackets balanced: " + balanced4);
        
    }

    public static boolean balanceParentheses(String str) {

        int unclosedOpenParentheses = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                unclosedOpenParentheses++;
            } else if (c == ')') {
                unclosedOpenParentheses--;
            }
            if (unclosedOpenParentheses < 0) {
                return false;
            }
        }
        return unclosedOpenParentheses == 0;
    }

    /*
        Write a function without that takes in a string and returns true or false based on
        whether the string’s opening-and-closing marks (that is, brackets) are
        balanced. Account for the following bracket types:
     
     *  Type              Opener Closer
        Parentheses        (       )
        Curly Braces       {       }
        Square Brackets    [       ]
        Angle Brackets     <       >
    
        The string doesn’t need to have all four types of brackets, but if an open
        bracket appears, the pair should also be closed correctly. Assume you can use
        any libraries in Java needed.
     */
    
    public static boolean balanceBrackets(String str) {

        int unclosedOpenBrackets = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                unclosedOpenBrackets++;
            } else if (c == ')' || c == '}' || c == ']' || c == '>') {
                unclosedOpenBrackets--;
            }
            if (unclosedOpenBrackets < 0) {
                return false;
            }
        }
        return unclosedOpenBrackets == 0;
    }

    
    /*
     * For Step 2, you could have used a Stack to implement the solution. How would
        you implement a stack if you could not use any of the built-in Java
        libraries?
     */
    public static boolean balanceStackBrackets(String str) {

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
