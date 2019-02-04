package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/sqrtx
 *
 * Created by zhaohongjie on 2019/2/3.
 */
public class SqrtX {

    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int l = 1;
        int r = x;

        int result = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                result = m;
            }
        }

        return result;
    }

    public int mySqrt_1(int x) {
        long r = x;
        while (r > x / r) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        int i = sqrtX.mySqrt_1(2147483647);
        System.out.println(i);
    }

}
