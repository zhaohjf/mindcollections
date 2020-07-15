package alg.zhj.campaign.week05.src;

import java.util.Arrays;

/**
 * 输入: m = 3, n = 2
 输出: 3
 解释:
 从左上角开始，总共有 3 条路径可以到达右下角。
 1. 向右 -> 向右 -> 向下
 2. 向右 -> 向下 -> 向右
 3. 向下 -> 向右 -> 向右
 示例 2:

 输入: m = 7, n = 3
 输出: 28
 *
 * Created by zhaohongjie on 2020/7/15.
 */
public class UniquePaths_62 {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int[] a : dp) {
            Arrays.stream(a).forEach(x -> System.out.print(x + " "));
            System.out.println();
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 因为是从下往上，所以是dp[i+1][j]而不是dp[i-1][j]
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
}
