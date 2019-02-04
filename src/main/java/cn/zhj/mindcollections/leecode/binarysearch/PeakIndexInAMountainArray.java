package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * Created by zhaohongjie on 2019/2/4.
 */
public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] A) {

        if (A == null || A.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            /**
             * 避免數組越界
             */
            if (m == 0 || m == A.length - 1) {
                return -1;
            }

            if (A[m - 1] <= A[m] && A[m] >= A[m + 1]) {
                return m;
            } else if (A[m] > A[m - 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public int peakIndexInMountainArray_1(int[] A) {
        int i = 0;
        for (i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                continue;
            } else {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        PeakIndexInAMountainArray obj = new PeakIndexInAMountainArray();
        int result = obj.peakIndexInMountainArray(new int[]{0, 1, 2, 3, 4});
        System.out.println(result);
    }
}
