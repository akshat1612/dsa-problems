package leetCodeDailyProblem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * You are given a string s that consists of lower case English letters and brackets.
 * <p>
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * <p>
 * Your result should not contain any brackets.
 */
public class LC1190_ReverseParentheses_11072024 {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
        s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    static String reverseParentheses(String st) {
        Stack<Character> s = new Stack<>();
        for (char ch : st.toCharArray()) {
            if (ch == ')') {
                Queue<Character> q = new LinkedList<>();
                while (!s.isEmpty()) {
                    char top = s.pop();
                    if (top == '(') {
                        break;
                    } else {
                        q.add(top);
                    }
                }
                while (!q.isEmpty()) {
                    s.push(q.poll());
                }
            } else {
                s.push(ch);
            }
        }
        StringBuilder a = new StringBuilder();
        Collections.reverse(s);
        while (!s.isEmpty()) {
            a.append(s.pop());
        }
        return a.toString();
    }
}
