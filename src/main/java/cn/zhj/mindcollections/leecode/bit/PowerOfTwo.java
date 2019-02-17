package cn.zhj.mindcollections.leecode.bit;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 *
 * Created by zhaohongjie on 2019/2/17.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        /**
         * 正数
         *
         */
        if (n > 0 && (n & (n - 1)) == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(6));
    }
}
