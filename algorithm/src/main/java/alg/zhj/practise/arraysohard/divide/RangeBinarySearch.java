package alg.zhj.practise.arraysohard.divide;

import edu.princeton.cs.algs4.In;

public class RangeBinarySearch {


    public int binarySearch(int[] nums, boolean equals, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        if (target > nums[nums.length - 1]) {
            return -1;
        }
        if (target == nums[nums.length - 1] && !equals) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int index = equals ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                if (equals) {
                    index = Math.min(index, mid);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                    index = Math.max(index, mid);
                }
//                index = mid;
//                if (!equals) {
//                    int i = mid;
//                    while (i <= r && nums[i] == nums[i+1]) {
//                        i++;
//                    }
//                    if (i == r) {
//                        return -1;
//                    } else {
//                        return i + 1;
//                    }
//                }
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (index != Integer.MIN_VALUE && index != Integer.MAX_VALUE) {
            return equals ? index : index + 1;
        }

        return r + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 6,6,6,7, 8, 9};
        RangeBinarySearch obj = new RangeBinarySearch();
        System.out.println(obj.binarySearch(nums, false, 9));
    }
}
