package alg.zhj.campaign.week06.src;

import java.util.Arrays;

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

    public int _uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] mem = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(mem[i],-1);
        }
        return dfsUniquePathsWithObstacles(obstacleGrid,0,0,mem);
    }

    private int dfsUniquePathsWithObstacles(int[][] board, int i, int j,int[][] mem) {
        if (i == board.length - 1 && j == board[0].length - 1 && board[i][j] == 0) {
            return 1;
        }
        if (i >= board.length || j >= board[0].length || board[i][j] == 1) {
            return 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int total = 0;
        total += dfsUniquePathsWithObstacles(board, i + 1, j, mem);
        total += dfsUniquePathsWithObstacles(board, i, j + 1, mem);
        mem[i][j] = total;
        return total;
    }

    public int __uniquePathsWithObstacles(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }

    public int ____uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1}};
        int i = uniquePathsWithObstacles(a);
        System.out.print(i);
    }
}
