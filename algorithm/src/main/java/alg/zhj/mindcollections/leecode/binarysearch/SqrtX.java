package alg.zhj.mindcollections.leecode.binarysearch;

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

    public double getSqrtRoot(int n, double deltaThreshold, int maxTry) {

        if (n <= 1) {
            return -1.0;
        }

        double l = 0;
        double r = (double) n;

        for (int i = 0; i < maxTry; i++) {
            double m = l + (r - l) / 2;
            double square = m * m;
            double delta = Math.abs((square / n) - 1);
            if (delta < deltaThreshold) {
                return m;
            } else {
                if (square > n) {
                    r = m;
                } else {
                    l = m;
                }
            }
        }

        return -2.0;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(4));
        double i = sqrtX.getSqrtRoot(10, 0.000001, 10000);
        System.out.println(i);
    }

}
