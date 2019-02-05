package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * Created by zhaohongjie on 2019/2/5.
 */
public class ArrangingCoins {

    /**
     * l从1开始时，计算sum时long会溢出
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {

        if (n == 0) {
            return 0;
        }

        int l = 1;
        int r = n;

        while (l <= r) {

            int m = l + (r - l) / 2;
            /**
             * 求1~m累计和
             *
             */
            long sum = (m + 1) * m / 2;
            if (sum <= n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l - 1;
    }

    public int arrangeCoins_2(int n) {
        long left = 0;
        long right = n;
        int k = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2;
            if ((sum <= n) && (sum + mid + 1 > n)) {
                k = (int) mid;
                break;
            } else if (sum > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return k;
    }

    public int arrangeCoins_3(int n) {
        return (int) ((Math.sqrt(8 * (long) n + 1) - 1) / 2);
    }

    /**
     * 902144692
     * 902144691
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int i = arrangingCoins.arrangeCoins_2(1804289383);

        System.out.println(i);
    }
}
