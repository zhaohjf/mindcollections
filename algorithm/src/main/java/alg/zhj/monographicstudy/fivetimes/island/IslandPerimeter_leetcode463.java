package alg.zhj.monographicstudy.fivetimes.island;

/**
 * 从一个点出发，遍历，然后回到初始点的过程
 *
 * Created by zhaohongjie on 2020/5/16.
 */
public class IslandPerimeter_leetcode463 {

    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int area = 0;
        int conn = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area++;
                    if (i > 0 && grid[i - 1][j] == 1) ++conn;
                    if (i < m - 1 && grid[i + 1][j] == 1) ++conn;
                    if (j > 0 && grid[i][j - 1] == 1) ++conn;
                    if (j < n - 1 && grid[i][j + 1] == 1) ++conn;
                }
            }
        }

        return 4 * area - conn;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1}};
        IslandPerimeter_leetcode463 obj = new IslandPerimeter_leetcode463();
        System.out.println(obj.islandPerimeter(a));
    }
}
