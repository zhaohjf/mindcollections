package alg.zhj.mindcollections.leecode.binarysearch;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * 有重复数字
 *
 * Created by zhaohongjie on 2019/2/6.
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        if ((nums1 == null || nums1.length <= 0)
                || (nums2 == null || nums2.length <= 0)) {
            return new int[]{};
        }

        List<Integer> res = new ArrayList<>();

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // 对两个数组都进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 遍历较短数组
        int i = 0;
        while (i < nums1.length) {

            int cnt1 = 1;
            int cnt2 = 1;

            int index = binarySearch(nums2, nums1[i]);
            if (index != -1) {

                //res.add(nums1[i]);

                // 遍历数组往右找是否有相同的元素
                for (int k = i + 1; k < nums1.length; k++) {
                    if (nums1[i] == nums1[k]) {
                        cnt1 += 1;
                    } else {
                        break;
                    }
                }

                // 目标数组往右查找
                for (int k = index + 1; k < nums2.length; k++) {
                    if (nums2[index] == nums2[k]) {
                        cnt2 += 1;
                    } else {
                        break;
                    }
                }

                // 目标数组往左查找
                for (int k = index - 1; k >= 0; k--) {
                    if (nums2[index] == nums2[k]) {
                        cnt2 += 1;
                    } else {
                        break;
                    }
                }

                // i移动最小值，并记录结果
                int min = Math.min(cnt1, cnt2);
                for (int k = 0; k < min; k++) {
                    res.add(nums1[i]);
                }
                i += cnt1;
            } else {
                i++;
            }
        }

        int[] result = new int[res.size()];
        int j = 0;
        for (Integer r : res) {
            result[j] = r;
            j++;
        }

        return result;
    }

    private int binarySearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    /**
     * 1,2,3,3,3,4,4,
     *
     * @param args
     */
    public static void main(String[] args) {
        IntersectionOfTwoArraysII obj = new IntersectionOfTwoArraysII();
        int[] intersect = obj.intersect(new int[]{3,1,2,1}, new int[]{1,1});

        for (int i : intersect) {
            System.out.print(i);
        }
    }

}
