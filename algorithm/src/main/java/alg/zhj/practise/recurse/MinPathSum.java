package alg.zhj.practise.recurse;

/**
 * https://leetcode.cn/problems/0i0mDW/
 */
public class MinPathSum {

    public int minPathSum_wrong(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        return recures(grid, row - 1, column - 1);
    }

    /**
     * 一起来找bug
     */
    private int recures(int[][] grid, int row, int column) {
        if (row < 0 || column < 0) {
            return 0;
        }
        return Math.min(recures(grid, row - 1, column), recures(grid, row, column - 1)) + grid[row][column];
    }

    /**=======================================================================================================================*/

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        return dfs(grid, row - 1, column - 1);
    }

    private int dfs(int[][] grid, int row, int column) {
        if (row == 0 && column == 0) {
            return grid[0][0];
        }
        if (row < 0 || column < 0) {
            return Integer.MAX_VALUE;
        }
        return Math.min(dfs(grid, row - 1, column), dfs(grid, row, column - 1)) + grid[row][column];
    }

    /**=======================================================================================================================*/

    public int minPathSum_dp(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        int sum = 0;
        for (int i = row - 1; i >= 0; i--) {
            sum += grid[i][column - 1];
            dp[i][column - 1] = sum;
        }
        sum = 0;
        for (int j = column - 1; j >= 0; j--) {
            sum += grid[row - 1][j];
            dp[row - 1][j] = sum;
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathSum obj = new MinPathSum();
        System.out.println(obj.minPathSum_dp(grid));
    }
}
