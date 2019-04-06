package cn.zhj.mindcollections.interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Created by zhaohongjie on 2019/4/6.
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        FindAllNumbersDisappearedInAnArray obj = new FindAllNumbersDisappearedInAnArray();
        obj.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).forEach(c -> System.out.print(c + " "));
    }
}
