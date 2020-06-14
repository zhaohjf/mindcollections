package alg.zhj.mindcollections.campaign.week01;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/6/12.
 */
public class MergeTwoSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // set two pointer point to the end of each array
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer point to the end of merging array
        int p = m + n - 1;

        // while there are still element to compare
        while (p1 >= 0 && p2 >= 0) {
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            if (nums2[p2] > nums1[p1]) {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            } else {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
        }

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public void _merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] > nums1[p1]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};

        MergeTwoSortedArray_88 obj = new MergeTwoSortedArray_88();
        obj._merge(num1, 3, num2, 3);

        Arrays.stream(num1).forEach(System.out::print);
    }
}
