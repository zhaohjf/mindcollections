package alg.zhj.campaign.week03.preview;

/**
 * Created by zhaohongjie on 2020/6/21.
 */
public class ClimbStairs_70 {

    /**
     * 递归 有重复计算 时间复杂度高
     * 时间 超时
     *
     * @param n
     * @return
     */
    public static int _recurse_climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return _recurse_climbStairs(n - 1) + _recurse_climbStairs(n - 2);
    }

    /**
     * 缓存递归结果
     * 时间 0ms
     *
     * @param n
     * @return
     */
    public static int _recurse_mem_climbStairs(int n) {
        return recurse(n, new int[n + 1]);
    }

    private static int recurse(int n, int[] index) {
        if (n <= 2) {
            return n;
        }
        if (index[n] > 0) {
            return index[n];
        }

        index[n] = recurse(n - 1, index) + recurse(n - 2, index);

        return index[n];
    }

    /**
     * 尾递归
     *
     * @param n
     * @return
     */
    public static int _recurse_tail_climbStairs(int n) {
        return fibonacci(n, 1, 1);
    }

    public static int fibonacci(int n, int a, int b) {
        if (n <= 1)
            return b;
        return fibonacci(n - 1, b, a + b);
    }

    /**
     * 动态规则
     *
     * @param n
     * @return
     */
    public static int _dp_climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 矩阵快速幂
     *
     */
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    private int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 通项公式
     *
     */
    public int __climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }
}
