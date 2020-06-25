package alg.zhj.campaign.week03.practise;

/**
 * Created by zhaohongjie on 2020/6/24.
 */
public class HammingDistance_461 {

    /**
     * 位运算，每次右移一位，判断最后一位是否为1
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }

        return count;
    }

    /**
     * z = z & (z - 1) 作用就是消去二进制数的最右侧的一个1
     *
     * 理论上的循环次数要小于上面算法
     *
     * @param x
     * @param y
     * @return
     */
    public int _hammingDistance(int x, int y) {
        int z = x ^ y;

        int count = 0;

        while (z != 0) {
            count++;
            z = z & (z - 1);
        }

        return count;
    }
}
