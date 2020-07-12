package alg.zhj.campaign.week05.preview;

/**
 * Created by zhaohongjie on 2020/7/12.
 */
public class LongestCommonSubsequence_1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                // 判断末端是否相同
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[s1.length][s2.length];
    }

    // Method1()- recursive solution(Top- down approach)
    // time complexity - O(2^(m+n))
    // space complexity - O(m+n)
    public static int LCSM1(char[] X, char[] Y, int i, int j) {
        if (i <= 0 || j <= 0)
            return 0;
        if (X[i - 1] == Y[j - 1])
            return 1 + LCSM1(X, Y, i - 1, j - 1);
        else
            return Math.max(LCSM1(X, Y, i, j - 1), LCSM1(X, Y, i - 1, j));

    }

    // Method2()- recursive solution with memoization
    // time complexity - O(m*n)
    // space complexity - O(m*n)
    public static int LCSM2(char[] X, char[] Y, int i, int j, Integer[][] dp) {
        if (i <= 0 || j <= 0)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (X[i - 1] == Y[j - 1])
            return 1 + LCSM2(X, Y, i - 1, j - 1, dp);
        else
            return dp[i][j] = Math.max(LCSM2(X, Y, i, j - 1, dp), LCSM2(X, Y, i - 1, j, dp));

    }

    // Method3()- DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(m*n)
    public static int LCSM3(char[] X, char[] Y, int m, int n) {
        int memo[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m][n];
    }

    // Method4()- DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(n)
    public static int LCSM4(char[] X, char[] Y, int m, int n) {
        int memo[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (X[i - 1] == Y[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }

        }
        return memo[n];
    }
}
