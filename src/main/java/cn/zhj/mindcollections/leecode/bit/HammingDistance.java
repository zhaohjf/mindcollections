package cn.zhj.mindcollections.leecode.bit;

/**
 * Created by zhaohongjie on 2019/2/14.
 */
public class HammingDistance {

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
