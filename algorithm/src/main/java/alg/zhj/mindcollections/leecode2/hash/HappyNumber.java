package alg.zhj.mindcollections.leecode2.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaohongjie on 2019/3/7.
 */
public class HappyNumber {

    /**
     * 暴力求解
     * <p>
     * 当平方的和开始重复时，表明这不是一快乐数，因此它会一直循环
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        Set<Integer> exist = new HashSet<>();
        while (exist.add(n)) {

            int sum = 0;
            while (n != 0) {
                int i = n % 10;
                n = n / 10;
                sum = sum + i * i;
            }

            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }

        return false;
    }

    /**
     * @param num
     * @return
     */
    public boolean isHappy_1(int num) {
        if (num < 10) {
            return num == 1 || num == 7;
        }
        int n = num;
        int b = 0;
        while (n > 0) {
            b += (n % 10) * (n % 10);
            n = n / 10;
        }
        return isHappy_1(b);
    }

    /**
     * 有循环的存在，就可以使用快慢指针方法来探测
     *
     * 快慢指针只需要O(1)的空间复杂度
     *
     * @param n
     * @return
     */
    boolean isHappy_2(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) return true;
        else return false;
    }

    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber obj = new HappyNumber();
        System.out.print(obj.isHappy_2(2));
    }

}
