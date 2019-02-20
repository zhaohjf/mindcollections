package cn.zhj.mindcollections.leecode.dynamic;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * Created by zhaohongjie on 2019/2/19.
 */
public class ClimbingStairs {

    /**
     * 先用递归总结公式，当递归中有很多重复计算时，考虑是否能用递推反过来去解决问题。
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int one_step_before = 1;
        int two_steps_before = 2;
        int all_ways = 0;

        for (int i = 3; i <= n; i++) {
            all_ways = one_step_before + two_steps_before;
            one_step_before = two_steps_before;
            two_steps_before = all_ways;
        }

        return all_ways;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(2));
    }
}
