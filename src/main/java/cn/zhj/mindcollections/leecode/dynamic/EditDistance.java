package cn.zhj.mindcollections.leecode.dynamic;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * Created by zhaohongjie on 2019/2/25.
 */
public class EditDistance {

    /**
     * DP两部曲
     * （1）状态：dp[i][j] —— word1前i个字符=>word2前j个字符 的最少步数（这里前i或j个字符中，是不包含i和j的）
     * （2）方程：
     *         if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
     *             dp[i][j] = dp[i - 1][j - 1];
     *         } else {
     *             dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
     *         }
     *
     *         1）如果当前的两个字符正好相等，那就不需要作任何操作，最小值=前一个操作的最小值
     *         2）如果当前的两个字条不相等，那么就需要对word1进行一次操作，来使这两个字符相等，有三种操作方式：insert,delete,replace
     *             i）  insert   —— dp[i - 1][j] + 1      在word1中增加一个字符，相当于在前i-1个字符基础上进行一次操作，在前i-1和j状态下，对word1进行一次insert，变成 dp[i][j]
     *             ii） delete   —— dp[i][j - 1] + 1      在word1中删除一个字符，相当于在word2中向前移动一个字符，
     *             iii）replace  —— dp[i - 1][j - 1] + 1  需要对两个字符都进行操作
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 将word1的前i个字符与word2的前0的字符匹配，需要进行i次删除操作
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("horse", "ros"));
    }
}
