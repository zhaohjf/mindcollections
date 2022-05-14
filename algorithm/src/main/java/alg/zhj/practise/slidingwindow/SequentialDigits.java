package alg.zhj.practise.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sequential-digits/
 */
public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int l = String.valueOf(low).length();
        int r = String.valueOf(high).length();
        String temp = "123456789";
        for (int i = l; i <= r; i++) {
            for (int j = 0; j + i < 10; j++) {
                String target = temp.substring(j, j + i);
                int targetValue = Integer.parseInt(target);
                if (targetValue >= low && targetValue <= high) {
                    ans.add(targetValue);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SequentialDigits obj = new SequentialDigits();
        List<Integer> res = obj.sequentialDigits(100, 300);
        res.forEach(x -> System.out.println(x));
    }
}
