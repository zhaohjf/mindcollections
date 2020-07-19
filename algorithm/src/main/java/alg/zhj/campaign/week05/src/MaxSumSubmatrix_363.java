package alg.zhj.campaign.week05.src;

/**
 * Created by zhaohongjie on 2020/7/19.
 */
public class MaxSumSubmatrix_363 {

    /**
     * 4层状态转移方程
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        int[][][][] dp = new int[rows + 1][cols + 1][rows + 1][cols + 1]; // from (i1,j1) to (i2,j2)
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                dp[i1][j1][i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i1][j1][i2][j2] = dp[i1][j1][i2 - 1][j2] + dp[i1][j1][i2][j2 - 1]
                                - dp[i1][j1][i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i1][j1][i2][j2] <= k && dp[i1][j1][i2][j2] > max) max = dp[i1][j1][i2][j2];
                    }
                }
            }
        }
        return max;
    }

    /**
     * 状态压缩
     *
     * @param matrix
     * @param k
     * @return
     */
    public int _maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                int[][] dp = new int[rows + 1][cols + 1]; // renew  // from (i1,j1) to (i2,j2)
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max) max = dp[i2][j2];
                    }
                }
            }
        }
        return max;
    }

    public int __maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) { // 枚举右边界
                for (int i = 0; i < rows; i++) { // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }
    // 在数组 arr 中，求不超过 k 的最大值
    private int dpmax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }

    private int _dpmax(int[] arr, int k) {
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0, 1}, {0, -2, 3}};
        System.out.println(maxSumSubmatrix(a, 2));
    }
}
