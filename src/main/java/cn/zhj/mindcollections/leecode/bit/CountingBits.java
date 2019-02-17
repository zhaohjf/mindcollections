package cn.zhj.mindcollections.leecode.bit;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * Created by zhaohongjie on 2019/2/17.
 */
public class CountingBits {

    public int[] countBits(int num) {

        int[] res = new int[num + 1];
        for (int i = 1; i <= num;i++) {
            res[i] = res[i & (i -  1)] + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ints = countingBits.countBits(2);

        for (int i : ints) {
            System.out.println(i);
        }
    }
}
