package alg.zhj.mindcollections.fail.island;

/**
 * Created by zhaohongjie on 2020/5/15.
 */
public class NumberOfIsland_Leetcode200 {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return ans;
    }

    /**
     * 20200515 bug: 递归退出条件里少了 grid[i][j] == '0'
     *
     * @param grid
     * @param i
     * @param j
     * @param m
     * @param n
     */
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i, j - 1, m, n);
        dfs(grid, i, j + 1, m, n);
    }

    public static void main(String[] args) {
        char[][] a = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        NumberOfIsland_Leetcode200 obj = new NumberOfIsland_Leetcode200();
        System.out.print(obj.numIslands(a));
    }
}
