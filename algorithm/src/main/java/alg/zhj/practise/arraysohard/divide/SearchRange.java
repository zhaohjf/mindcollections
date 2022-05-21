package alg.zhj.practise.arraysohard.divide;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        int fromLeft = binarySearch(nums, target, true);
        int fromRight = binarySearch(nums, target, false);

        if (fromLeft == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{fromLeft, fromRight};
    }

    private int binarySearch(int[] nums, int target, boolean fromLeft) {
        int l = 0;
        int r = nums.length - 1;
        int index = fromLeft ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                if (fromLeft) {
                    index = Math.min(index, mid);
                    r = mid - 1;
                } else {
                    index = Math.max(index, mid);
                    l = mid + 1;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        SearchRange obj = new SearchRange();
        Arrays.stream(obj.searchRange(nums,2)).forEach(x -> System.out.println(x));
    }
}
