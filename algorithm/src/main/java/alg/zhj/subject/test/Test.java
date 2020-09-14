package alg.zhj.subject.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaohongjie on 2020/9/6.
 */
public class Test {

    public static int lengthOfLastWord(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        for (int i = c.length - 1; i >= 0 ; i--) {
            if (c[i] == ' ' && ans == 0) {
                continue;
            } else if (c[i] == ' ' && ans > 0) {
                break;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLastWord("a"));
    }
}
