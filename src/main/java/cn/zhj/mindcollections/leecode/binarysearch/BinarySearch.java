package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * Created by zhaohongjie on 2019/2/4.
 */
public class BinarySearch {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

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

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(result);
    }
}
