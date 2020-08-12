package alg.zhj.campaign.week08.practise;

/**
 * Created by zhaohongjie on 2020/8/11.
 */
public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, new boolean[image.length][image[0].length], image[sr][sc], newColor);
        return image;
    }

    private static void dfs(int[][] image, int i, int j, boolean[][] visited, int color, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != color) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        image[i][j] = newColor;
        visited[i][j] = true;
        dfs(image, i, j - 1, visited, color, newColor);
        dfs(image, i, j + 1, visited, color, newColor);
        dfs(image, i - 1, j, visited, color, newColor);
        dfs(image, i + 1, j, visited, color, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] ints = floodFill(image, 1, 1, 2);
        System.out.println();
    }
}
