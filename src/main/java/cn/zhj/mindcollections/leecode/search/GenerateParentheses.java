package cn.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * Created by zhaohongjie on 2019/1/29.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateEach(result, "", 0, 0, n);
        return result;
    }

    /**
     * 使用递归求值，重点要理解递归的执行逻辑
     *
     * @param result
     * @param parentheses
     * @param left
     * @param right
     * @param n
     */
    public void generateEach(List<String> result, String parentheses, int left, int right, int n) {

        if (left == n && right == n) {
            result.add(parentheses);
            return;
        }

        if (left < n) {
            generateEach(result, parentheses + "(", left + 1, right, n);
        }

        if (left > right) {
            generateEach(result, parentheses + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> list = generateParentheses.generateParenthesis(3);
        list.forEach(c -> System.out.println(c));
    }
}
