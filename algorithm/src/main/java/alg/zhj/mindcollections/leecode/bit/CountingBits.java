package alg.zhj.mindcollections.leecode.bit;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * Created by zhaohongjie on 2019/2/17.
 */
public class CountingBits {

    /**
     * i & (i -  1) 去掉最后的一位1
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {

        int[] res = new int[num + 1];
        /**
         * res[0] = 0
         * i & (i -  1) < i是下面算法成立的必要条件
         *
         * 类似于DP问题
         */
        for (int i = 1; i <= num;i++) {
            res[i] = res[i & (i -  1)] + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ints = countingBits.countBits(5);

        for (int i : ints) {
            System.out.println(i);
        }
    }
}
