package alg.zhj.mindcollections.leecode.bit;

/**
 * Created by zhaohongjie on 2019/2/14.
 */
public class HammingWeight {

    /**
     * java中的int都是默认有符号位的，因此，取模运算对于负数的计算是不准确的。
     *
     * @param n
     * @return
     */
    public int hammingWeight_1(int n) {

        int result = 0;

        if (n == 0) {
            return result;
        }

        while (n != 0) {

            if (n % 2 == 1) {
                result += 1;
            }

            n = n >>> 1;
        }

        return result;
    }

    /**
     * 最好成绩：
     *
     * 执行用时: 3 ms,
     * 内存消耗: 24.3 MB,
     *
     * @param n
     * @return
     */
    public int hammingWeight_2(int n) {

        int result = 0;
        int mask = 1;

        if (n == 0) {
            return result;
        }

        for (int i = 0; i < 32; i++) {
            if ((mask & n) == mask) {
                result += 1;
            }
            mask = mask << 1;
        }

        return result;
    }

    /**
     * 执行用时: 3 ms,
     * 内存消耗: 24.3 MB,
     *
     * @param n
     * @return
     */
    public int hammingWeight_3(int n) {

        int result = 0;

        while (n != 0) {
            result += 1;
            n = n & (n - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight_1(-3));
        System.out.println(hammingWeight.hammingWeight_2(-3));
        System.out.println(hammingWeight.hammingWeight_3(-3));
    }

}
