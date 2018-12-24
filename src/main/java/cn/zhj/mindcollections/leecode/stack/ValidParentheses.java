package cn.zhj.mindcollections.leecode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhaohongjie on 2018/12/24.
 */
public class ValidParentheses {

    /**
     * 16ms
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> paren_map = new HashMap<>();
        paren_map.put(')', '(');
        paren_map.put(']', '[');
        paren_map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (paren_map.values().contains(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !paren_map.get(c).equals(stack.pop())) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 7ms
     *
     * @param s
     * @return
     */
    public static boolean isValid_2(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < s.length();i++){
            char c = s.charAt(i);
            if (stack.size() > 0){
                char p = stack.peek();
                if (p=='(' && c==')'|| p=='[' && c==']' || p=='{' && c=='}') stack.pop();
                else stack.push(c);
            }else{
                stack.push(c);
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        isValid("()");
    }
}
