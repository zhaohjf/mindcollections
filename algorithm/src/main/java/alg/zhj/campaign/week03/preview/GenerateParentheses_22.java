package alg.zhj.campaign.week03.preview;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * {@link alg.zhj.mindcollections.leecode.search.GenerateParentheses}
 * Created by zhaohongjie on 2020/6/21.
 */
public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        generateEach(ans, "", 0, 0, n);
        return ans;
    }

    private void generateEach(List<String> result, String parentheses, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(parentheses);
            return;
        }
        if (left < n) {
            generateEach(result, parentheses + "(", left + 1, right, n);
        }
        // 如果要生成有效括号，这里必须是 left > right
        if (left > right) {
            generateEach(result, parentheses + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses_22 obj = new GenerateParentheses_22();
        List<String> stringList = obj.generateParenthesis(3);
        stringList.forEach(x -> System.out.println(x));
    }
}
