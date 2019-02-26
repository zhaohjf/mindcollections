package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 *
 * 难点：要通过二分法，查找两个数
 *
 * Created by zhaohongjie on 2019/2/4.
 */
public class TwoSumII {

    /**
     * 题目前提是数组是有序的，有序的话一般也就只有用二分查找来实现
     *
     * 该题应用的是变种的二分查找法，头尾各放置一个指针，依次向中间移动，计算两个指针指向元素之各是否等于target。
     *
     * 最好时间复杂度是O(n/2)，最差为O(n)。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length <= 0) {
            return new int[]{};
        }

        int l = 0;
        int r = numbers.length - 1;

        while (l <= r) {
            int m = numbers[l] + numbers[r];
            if (m == target) {
                return new int[]{l + 1, r + 1};
            } else if (m < target) {
                l += 1;
            } else {
                r -= 1;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] ints = twoSumII.twoSum(new int[]{2, 7, 11, 15}, 9);

        for (int i : ints) {
            System.out.println(i);
        }
    }
}
