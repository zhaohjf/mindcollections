package alg.zhj.campaign.week04.preview;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square
 *
 * Created by zhaohongjie on 2019/3/6.
 */
public class ValidPerfectSquare_367 {

    /**
     * 注意数字溢出问题，两个较大的int相乘，值可能会溢出，所以需要提前将它们转换到long；而将两个较大int的乘积赋给一个long值是不行的。
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {

        if (num <= 0) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        long l = 1;
        long r = num/2;  // 这里除以2是因为，求一个数n的平方根x，必然有 x <= n/2 的性质
        while (l <= r) {
            long m = l + (r - l) / 2;
            long square = m * m;
            if (square == num) {
                return true;
            } else if (square < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }

    public boolean isPerfectSquare_1(int num) {
        if(num <= 0)
            return false;
        if(num == 1)
            return true;
        long l=1, r = num/2;
        long mid, midSq;
        while(l <= r){
            mid = (l + r)/2;
            midSq = mid * mid;
            if(midSq == num) return true;
            if(midSq < num) l = mid+1;
            else r = mid-1;
        }
        return false;
    }


    /**
     * "A square number is 1+3+5+7+..." is a pre-conceived knowledge.
     * Unless, we haven't heard it before, coming up with that is very rare.
     *
     * This is a math problem：
     1 = 1
     4 = 1 + 3
     9 = 1 + 3 + 5
     16 = 1 + 3 + 5 + 7
     25 = 1 + 3 + 5 + 7 + 9
     36 = 1 + 3 + 5 + 7 + 9 + 11
     ....
     so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
     *
     * @param num
     * @return
     */
    public boolean _isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        ValidPerfectSquare_367 obj = new ValidPerfectSquare_367();
        System.out.println(obj._isPerfectSquare(9));
    }
}
