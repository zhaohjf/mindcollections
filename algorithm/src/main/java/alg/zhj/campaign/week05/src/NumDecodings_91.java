package alg.zhj.campaign.week05.src;

/**
 * Created by zhaohongjie on 2020/7/17.
 */
public class NumDecodings_91 {

    int numDecodings(String s) {
        if (s == null || s == "" || s.startsWith("0")) {
            return 0;
        }
        char[] c = s.toCharArray();
        int[] dp = new int[c.length + 1];
        dp[0] = 1;
        dp[1] = c[0] == '0' ? 0 : 1;
        for (int i = 2; i <= c.length; i++) {
            if (c[i - 1] >= '1' && c[i - 1] <= '9') {
                dp[i] += dp[i - 1];
            }
            if (c[i - 2] == '1') {
                dp[i] += dp[i - 2];
            } else if (c[i - 2] == '2' && c[i - 1] <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[c.length];
    }
}
