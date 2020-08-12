package alg.zhj.special.fivetimes.island;

/**

给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。

网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

 

示例 :

输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

输出: 16

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/island-perimeter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


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
