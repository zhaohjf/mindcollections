package alg.zhj.campaign.week05.src;

/**
 * Created by zhaohongjie on 2020/7/16.
 */
public class UniquePathsWithObstacles_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for (int i = m - 1; i >= 0; i--) {
            if (flag) {
                dp[i][n - 1] = 0;
                continue;
            }
            if (obstacleGrid[i][n - 1] == 1) {
                dp[i][n - 1] = 0;
                flag = true;
            } else {
                dp[i][n - 1] = 1;
            }
        }
        flag = false;
        for (int j = n - 1; j >= 0; j--) {
            if (flag) {
                dp[m - 1][j] = 0;
                continue;
            }
            if (obstacleGrid[m - 1][j] == 1) {
                dp[m - 1][j] = 0;
                flag = true;
            } else {
                dp[m - 1][j] = 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1}};
        int i = uniquePathsWithObstacles(a);
        System.out.print(i);
    }
}
