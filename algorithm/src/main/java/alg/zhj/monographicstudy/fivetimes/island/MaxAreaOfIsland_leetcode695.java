package alg.zhj.monographicstudy.fivetimes.island;

/**
 * Created by zhaohongjie on 2020/5/16.
 */
public class MaxAreaOfIsland_leetcode695 {

    int maxArea;

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    res = Math.max(res, maxArea);
                    maxArea = 0;
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        ++maxArea;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        MaxAreaOfIsland_leetcode695 obj = new MaxAreaOfIsland_leetcode695();
        System.out.print(obj.maxAreaOfIsland(a));
    }
}
