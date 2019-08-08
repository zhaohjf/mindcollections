package alg.zhj.mindcollections.leecode.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * Created by zhaohongjie on 2019/2/5.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        if ((nums1 == null || nums1.length <= 0)
                || (nums2 == null || nums2.length <= 0)) {
            return new int[]{};
        }

        Set<Integer> res = new HashSet<>();

        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        // 对较短数组排序
        Arrays.sort(nums2);

        // 遍历另一个数组，使用二分查找在较短数组中查找元素是否存在。
        for (int i : nums1) {
            if (binarySearch(nums2, i)) {
                res.add(i);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for (Integer r : res) {
            result[i] = r;
            i++;
        }

        return result;
    }

    private boolean binarySearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();
        int[] result = obj.intersection(new int[]{1, 2}, new int[]{1, 1});

        for (int i : result) {
            System.out.print(i);
        }
    }
}
