package replay;

import com.google.common.collect.Maps;

import java.util.*;

public class TwoSum {

    /**
     * 找到和等于target的两个元素下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])) {
                return new int[]{i, index.get(target - nums[i])};
            } else {
                index.put(nums[i], i);
            }
        }

        return null;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int twoSumCount(int[] nums, int target) {

        int count = 0;
        Map<Integer, Integer> index  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(100 - nums[i])) {
                count += index.get(100 - nums[i]);
            }
            index.put(nums[i], index.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }

    /**
     * 数组有序情况下的两数之和
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumWithIncreasingOrderedArray(int[] numbers, int target) {
        int l = 0; int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l, r};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l, r};
    }

    /**
     * alg.zhj.mindcollections.leecode.binarysearch.TwoSumIV
     *      #find(alg.zhj.mindcollections.leecode.binarytree.search.TreeNode, int, java.util.Set)
     * 二叉搜索树之两数之和
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 20, 80, 20, 80, 6, 70,30, 70, 2};
        System.out.println(twoSumCount(nums, 100));
    }
}
