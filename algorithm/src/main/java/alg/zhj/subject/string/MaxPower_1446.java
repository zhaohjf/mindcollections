package alg.zhj.subject.string;

/**
 * Created by zhaohongjie on 2020/8/15.
 */
public class MaxPower_1446 {

    public int maxPower(String s) {
        char[] c = s.toCharArray();
        char cur = c[0];
        int count = 1, ans = 1;
        for (int i = 1; i < c.length; i++) {
            if (cur == c[i]) {
                count++;
            } else {
                ans = Math.max(ans, count);
                cur = c[i];
                count = 1;
            }
        }
        return Math.max(ans, count);
    }

    public int _maxPower(String s) {
        int ans = 1;
        for (int i = 1, cnt = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1))
                cnt++;
            else
                cnt = 1;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxPower_1446 obj = new MaxPower_1446();
        System.out.println(obj.maxPower("leetcode"));
    }
}
