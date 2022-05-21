package alg.zhj.practise.arraysohard.sortkind;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/next-permutation/
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从右到左，找第一个逆序对（逆序数）
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        // 如果没有找到逆序数，说明已是倒序，反转即可
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        // 找到该逆序的数字后面比它大的最小数字
        int j = nums.length - 1;
        while (j > 0 && nums[j] <= nums[i]) j--;
        // 交换两个数的位置
        swap(nums, i, j);
        // 反转后面的元素(必然是有序的)
        reverse(nums, i + 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int i) {
        int start = i, end = nums.length - 1;
        while (start < end)
            swap(nums, start++, end--);
    }
}
