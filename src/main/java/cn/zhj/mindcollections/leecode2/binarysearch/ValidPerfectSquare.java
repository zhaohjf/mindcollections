package cn.zhj.mindcollections.leecode2.binarysearch;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square
 *
 * Created by zhaohongjie on 2019/3/6.
 */
public class ValidPerfectSquare {

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
        long r = num/2;
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

    public static void main(String[] args) {
        ValidPerfectSquare obj = new ValidPerfectSquare();
        System.out.println(obj.isPerfectSquare(808201));
    }
}
