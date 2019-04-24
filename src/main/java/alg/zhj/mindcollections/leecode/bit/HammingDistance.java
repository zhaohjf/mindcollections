package alg.zhj.mindcollections.leecode.bit;

/**
 * Created by zhaohongjie on 2019/2/14.
 */
public class HammingDistance {

    /**
     * 对两个数求异或值，这样，两个数中对应位相同的都会变成0，不同的变成1
     *
     * 所以，接下来，只需要统计二进制数的为1有个数。
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {

        int z = x ^ y;

        int count = 0;

        while (z != 0) {
            count++;
            z = z & (z - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        System.out.println(obj.hammingDistance(1, 4));
    }
}
