package alg.zhj.practise.recurse;

/**
 * https://leetcode.cn/problems/0i0mDW/
 */
public class minPathSum {

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

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum obj = new minPathSum();
        System.out.println(obj.minPathSum(grid));
    }
}
