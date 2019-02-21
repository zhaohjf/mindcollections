package cn.zhj.mindcollections.leecode.dynamic;

/**
 * https://leetcode-cn.com/problems/student-attendance-record-ii/
 *
 * Created by zhaohongjie on 2019/2/20.
 */
public class StudentAttendanceRecordII {

    static final int M = 1000000007;

    /**
     * P[i]    表示前i个排列中，以P结尾的个数
     * PorL[i] 表示前i个排列中，以P或L结尾的个数
     *
     * 这个解法的精髓是我们先不考虑字符A的情况，而是先把定义的这两个数组先求出来。
     * 由于P字符可以再任意字符后面加上，所以 P[i] = PorL[i-1]；
     *
     * 而PorL[i]由两部分组成，P[i] + L[i]，其中P[i]已经更新了，L[i]只能当前一个字符是P，或者前一个字符是L且再前一个字符是P的时候加上，即为P[i-1] + P[i-2]，所以PorL[i] = P[i] + P[i-1] + P[i-2]。

     那么我们就已经把不包含A的情况求出来了，存在了PorL[n]中，下面就是要求包含一个A的情况，那么我们就得去除一个字符，从而给A留出位置。那么就相当于在数组的任意一个位置上加上A，那么数组就被分成左右两个部分了，而这两个部分当然就不能再有A了，实际上所有不包含A的情况都已经在数组PorL中计算过了，而分成的子数组的长度又不会大于原数组的长度，所以我们直接在PorL中取值就行了，两个子数组的排列个数相乘，然后再把所有分割的情况累加起来就是最终结果啦
     *
     *
     * @param n
     * @return
     */
    public int checkRecord(int n) {

        // ending with P or L, na A
        long[] pOrL = new long[n + 1];
        // ending with P, no A
        long[] p = new long[n + 1];

        // 初始条件
        p[0] = pOrL[0] = 1;pOrL[1] = 2;p[1] = 1;

        // 计算出pOrL数组
        for (int i = 2; i <= n; i++) {
            p[i] = pOrL[i - 1];
            pOrL[i] = (p[i] + p[i - 1] + p[i - 2]) % M;
        }

        long res = pOrL[n];
        for (int i = 0; i < n; i++) {
            long s = (pOrL[i] * pOrL[n - i - 1]) % M;
            res = (res + s) % M;
        }

        return (int) res;
    }

    /**
     * Let f[i][j][k] denote the # of valid sequences of length i where:
     * There can be at most j A's in the entire sequence.
     * There can be at most k trailing L's.
     * We give the recurrence in the following code, which should be self-explanatory, and the final answer is f[n][1][2].
     *
     * @param n
     * @return
     */
    public int checkRecord_2(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    f[i][j][k] = val;
                }
        return f[n][1][2];
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII obj = new StudentAttendanceRecordII();
        System.out.println(obj.checkRecord_2(100));
    }
}
