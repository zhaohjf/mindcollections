package alg.zhj.practise.stack;

import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/7/31.
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        String s1 = process(S);
        String t1 = process(T);
        if (s1.intern() == t1.intern()) {
            return true;
        } else {
            return false;
        }
    }

    private String process(String str) {
        Stack<Character> stack = new Stack<>();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!stack.isEmpty() && c[i] == '#') {
                stack.pop();
            } else if (c[i] != '#') {
                stack.push(c[i]);
            }
        }
        int size = stack.size();
        char[] tmp = new char[size];
        int m = 0;
        while(!stack.isEmpty()) {
            tmp[m++] = stack.pop();
        }
        return new String(tmp);
    }

    public boolean _backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        BackspaceCompare obj = new BackspaceCompare();
        boolean b = obj.backspaceCompare("y#fo##f", "y#f#o##f");
        System.out.print(b);
    }
}
