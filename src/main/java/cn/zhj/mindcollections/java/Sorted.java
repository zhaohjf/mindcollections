package cn.zhj.mindcollections.java;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaohongjie on 2019/3/23.
 */
public class Sorted {

    public static int[] bubleSort(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static int[] selectionSort(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }

    public static int[] shellSort(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return nums;
        }

        int current;
        for (int i = 0; i < nums.length - 1; i++) {
            current = nums[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }

        return nums;
    }

    public static int[] insertionSort(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return nums;
        }

        int len = nums.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                temp = nums[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && temp < nums[preIndex]) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = temp;
            }
            gap /= 2;
        }

        return nums;
    }

    public static int[] uniqArray(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return nums;
        }

        int index = 0;
        int count = 1;
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (current != nums[i]) {

                nums[index + 1] = nums[i];
                current = nums[i];
                index++;
                count++;
            }
        }

        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] bubleSort = bubleSort(new int[]{10, 2, 5, 7, 1, 9, 8, 3});
//        for (int i = 0; i < bubleSort.length; i++) {
//            System.out.print(bubleSort[i] + ", ");
//        }
//        System.out.println();

//        int[] selectionSort = selectionSort(new int[]{10, 2, 5, 7, 1, 9, 8, 3});
//        for (int i = 0; i < selectionSort.length; i++) {
//            System.out.print(selectionSort[i] + ", ");
//        }
//        System.out.println();

//        int[] insertionSort = insertionSort(new int[]{10, 2, 5, 7, 1, 9, 8, 3});
//        for (int i = 0; i < insertionSort.length; i++) {
//            System.out.print(insertionSort[i] + ", ");
//        }
//        System.out.println();

        int[] shellSort = shellSort(new int[]{10, 2, 5, 7, 1, 9, 8, 3});
        for (int i = 0; i < shellSort.length; i++) {
            System.out.print(shellSort[i] + ", ");
        }
        System.out.println();

        int[] uniqArray = uniqArray(new int[]{1,1,2,3,3,4,5});
        for (int i = 0; i < uniqArray.length; i++) {
            System.out.print(uniqArray[i] + ", ");
        }
        System.out.println();
    }
}
