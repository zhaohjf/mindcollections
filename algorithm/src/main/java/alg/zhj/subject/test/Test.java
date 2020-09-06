package alg.zhj.subject.test;

/**
 * Created by zhaohongjie on 2020/9/6.
 */
public class Test {

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = average(M, m, n, i, j);
            }
        }
        return ans;
    }

    private int average(int[][] M, int m, int n, int i, int j) {
        int sum = M[i][j];
        int count = 0;
        for (int[] direct : directions) {
            int ni = i + direct[0], nj = j + direct[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                continue;
            }
            count++;
            sum += M[ni][nj];
        }
        if (count == 0) return 0;
        return sum / count;
    }

    public static void main(String[] args) {
        int[][] a = {{1,1,1},
                {1,0,1},
                {1,1,1}};
        Test obj = new Test();
        System.out.print(obj.imageSmoother(a));
    }
}
