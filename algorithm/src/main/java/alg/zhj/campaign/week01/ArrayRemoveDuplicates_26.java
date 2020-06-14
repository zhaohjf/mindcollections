package alg.zhj.campaign.week01;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/6/11.
 */
public class ArrayRemoveDuplicates_26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                continue;
            }
            nums[count] = nums[i];
            temp = nums[i];
            count++;
        }

        return count;
    }

    /**
     * 比较简洁
     *
     * @param nums
     * @return
     */
    public int _removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int __removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int id = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[id++] = nums[i];
            }
        }
        return id;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        ArrayRemoveDuplicates_26 obj = new ArrayRemoveDuplicates_26();
        System.out.println(obj.__removeDuplicates(a));
        Arrays.stream(a).forEach(System.out::print);
    }
}
