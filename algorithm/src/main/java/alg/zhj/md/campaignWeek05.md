```
  public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
```

```
package alg.dy;

/**
 * @author zhaohongjie <zhaohongjie03@kuaishou.com>
 * Created on 2020-07-17
 */
public class NumDecodings {

    /**
     * 要看前两个数
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
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
//
//
//        for (int i = 1; i < c.length; i++) {
//            if (c[i - 1] == '0' && c[i] == '0') {
//                return 0;
//            }
//            if (c[i - 1] == '1' && c[i] != '0') {
//                dp[i] = dp[i - 1] + 1;
//            } else if (c[i - 1] == '2' && c[i] <= '6') {
//                dp[i] = dp[i - 1] + 1;
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[c.length - 1];
    }

    /**
     * I used a dp array of size n + 1 to save subproblem solutions.
     * dp[0] means an empty string will have one way to decode,
     * dp[1] means the way to decode a string of size 1.
     * I then check one digit and two digit combination and save the results along the way.
     * In the end, dp[n] will be the end result.
     * @param s
     * @return
     */
    public static int _numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    static int M = 1000000007;
    public static int __numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
        }
        return (int) dp[s.length()];
    }

    public static int wildNumDecoding(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        long[] dp = new long[c.length + 1];
        dp[0] = 1;
        dp[1] = c[0] == '0' ? 0 : c[0] == '*' ? 9 : 1;
        for (int i = 2; i <= c.length; i++) {
            if (c[i - 1] == '*') {
                dp[i] = dp[i - 1] * 9;
                if (c[i - 2] == '1') {
                    dp[i] = (dp[i] + dp[i - 2] * 9) % M;
                } else if (c[i - 2] == '2') {
                    dp[i] = (dp[i] + dp[i - 2] * 6) % M;
                } else if (c[i - 2] == '*') {
                    dp[i] = (dp[i] + dp[i - 2] * 15) % M;
                }
            } else {
                dp[i] = c[i - 1] == '0' ? 0 : dp[i - 1];
                if (c[i - 2] == '1') {
                    dp[i] = (dp[i] + dp[i - 2]) % M;
                } else if (c[i - 2] == '2' && c[i - 1] <= '6') {
                    dp[i] = (dp[i] + dp[i - 2]) % M;
                } else if (c[i - 2] == '*') {
                    dp[i] = (dp[i] + (c[i - 1] <= '6' ? 2 : 1) * dp[i - 2]) % M;
                }
            }
        }
        return (int) dp[c.length];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("27"));
        System.out.println(wildNumDecoding("**********1111111111"));
        System.out.println(__numDecodings("**********1111111111"));
    }
}

```
