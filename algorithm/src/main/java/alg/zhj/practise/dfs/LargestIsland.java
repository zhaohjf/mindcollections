package alg.zhj.practise.dfs;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/making-a-large-island/submissions/
 *
 */
public class LargestIsland {

    boolean hasZero = true;

    /**
     * 会超时
     *
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int largest = 0;

        boolean allone = true;
        boolean allzero = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nextV(grid, m, m, i, j)) {
//                    hasZero = false;
                    grid[i][j] = 1;
                    largest = Math.max(largest, getArea(grid));
                    grid[i][j] = 0;
                }
                if (grid[i][j] == 0) {
                    allone = false;
                }
                if (grid[i][j] == 1) {
                    allzero = false;
                }
            }
        }
        if (allone) return m * n;
        if (allzero) return 1;
        return largest;
    }
    private boolean nextV(int[][] grid, int m, int n, int i, int j) {
        if (grid[i][j] != 0) {
            return false;
        }

        if (i > 0 && grid[i - 1][j] == 1) { return true;}
        if (i < m - 1 && grid[i + 1][j] == 1) { return true;}
        if (j > 0 && grid[i][j - 1] == 1) { return true;}
        if (j < n - 1 && grid[i][j + 1] == 1) { return true;}
        return false;
    }
    int currArea = 0;
    private int getArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] exists = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, exists, m, n, i, j);
                    ans = Math.max(ans, currArea);
                    currArea = 0;
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid, boolean[][] exists, int m, int n, int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1 && exists[i][j] == false) {
            currArea++;
            exists[i][j] = true;
            dfs(grid, exists, m, n, i - 1, j);
            dfs(grid, exists, m, n, i + 1, j);
            dfs(grid, exists, m, n, i, j - 1);
            dfs(grid, exists, m, n, i, j + 1);
        }
    }
    /** 上面代码是错的哈 */
    /**==================================================================================================================*/

    public int largestIsland_2(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int res = 0; // 当前最大面积岛屿
        int index = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, m, n, i, j, index);
                    map.put(index, area);
                    index++;
                    res = Math.max(res, area);
                }
            }
        }
        if (res == 0) {
            return 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighbour = getNeighbour(grid, m, n, i, j);
                    if (neighbour.size() < 1) {
                        continue;
                    }
                    int newArea = 1;
                    for (int neighbourIndex : neighbour) {
                        newArea += map.get(neighbourIndex);
                    }
                    res = Math.max(res, newArea);
                }
            }
        }

        return res;
    }

    private Set<Integer> getNeighbour(int[][] grid, int m, int n, int i, int j) {
        Set<Integer> ans = new HashSet<>();

        if (i > 0 && grid[i - 1][j] != 0) {
            ans.add(grid[i - 1][j]);
        }
        if (i < m - 1 && grid[i + 1][j] != 0) {
            ans.add(grid[i + 1][j]);
        }
        if (j > 0 && grid[i][j - 1] != 0) {
            ans.add(grid[i][j - 1]);
        }
        if (j < n - 1 && grid[i][j + 1] != 0) {
            ans.add(grid[i][j + 1]);
        }

        return ans;
    }

    private int getArea(int[][] grid, int m, int n, int i, int j, int index) {
        if (!(i >= 0 && j >= 0 && i < m && j < n)) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        return 1
                + getArea(grid, m, n, i - 1, j, index)
                + getArea(grid, m, n, i + 1, j, index)
                + getArea(grid, m, n, i, j - 1, index)
                + getArea(grid, m, n, i, j + 1, index);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0}, {0, 1}};
        LargestIsland obj = new LargestIsland();
        System.out.println(obj.largestIsland_2(grid));
    }
}
