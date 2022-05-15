package alg.zhj.practise.dfs;

public class ClosedIsland {

    boolean edge = false;
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, m, n, i, j);
                    ans += edge ? 0 : 1;
                    edge = false;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int m, int n, int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 0) {
            grid[i][j] = 1;
            if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                edge = true;
            }
            dfs(grid, m, n, i - 1, j);
            dfs(grid, m, n, i + 1, j);
            dfs(grid, m, n, i, j - 1);
            dfs(grid, m, n, i, j + 1);
        }
    }

    public static void main(String[] args) {
        ClosedIsland obj = new ClosedIsland();
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(obj.closedIsland(grid));
    }
}
