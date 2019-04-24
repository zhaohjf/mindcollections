package alg.zhj.mindcollections.leecode.other;

/**
 * Created by zhaohongjie on 2019/1/10.
 */
public class Pow {

    /**
     * 递归太深，会导致栈溢出
     *
     * 在leecode中运行,给定资源前提下会出现栈溢出
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        }

        return myPow(x * x, n / 2);
    }

    /**
     * 相对来说，下面递归的深度要远小于上面算法的递归深度
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow_4(double x, int n) {

        if(n == 0){
            return 1d;
        }

        double d = myPow(x, n / 2);

        if(n%2 == 0) {
            return d * d;
        }

        if(n < 0) {
            return d * d * (1 / x);
        }

        return d * d * x;
    }

    public double myPow_2(double x, int n) {


        if (n < 0) {
            x = 1 / x;
            if (Integer.MIN_VALUE == n) {
                n = Integer.MAX_VALUE;
                x *= x;
            } else {
                n = -n;
            }

        }

        double pow = 1;

        while (n > 0) {

            if ((n & 1) == 1) {
                pow *= x;
            }

            x *= x;
            n >>= 1;
        }

        return pow;
    }

    public double myPow_3(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double halfPow = myPow(x, n / 2);
        if (n % 2 == 0) {
            return halfPow * halfPow;
        }
        if (n > 0) {
            return x * halfPow * halfPow;
        }
        return (1 / x) * halfPow * halfPow;
    }

    public static void main(String[] args) {

        Pow pow = new Pow();

        double v = pow.myPow_2(2, 4);

        System.out.println(v);
    }

}
