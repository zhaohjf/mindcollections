package cn.zhj.mindcollections.leecode2.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/single-number
 *
 * Created by zhaohongjie on 2019/3/7.
 */
public class SingleNumber {

    /**
     * 神奇的异或
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }

    /**
     * 2*(a+b+c)−(a+a+b+b+c)=c
     *
     * @param nums
     * @return
     */
    public int singleNumber_1(int[] nums) {

        int sum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            sum = sum + i;
            set.add(i);
        }

        int uniqSum = 0;
        for (int value : set) {
            uniqSum = uniqSum + value;
        }

        return 2 * uniqSum - sum;
    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber_1(new int[]{4, 1, 2, 1, 2}));
    }

}
