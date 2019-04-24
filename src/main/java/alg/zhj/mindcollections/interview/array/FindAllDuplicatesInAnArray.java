package alg.zhj.mindcollections.interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 *
 * Created by zhaohongjie on 2019/4/6.
 */
public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                res.add(index + 1);
            }
        }

        return res;
    }

    /**
     * 速度会更快些
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates_1(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++)
            count[nums[i]]++;

        for (int i = 0; i < count.length; i++)
            if (count[i] == 2)
                result.add(i);

        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray obj = new FindAllDuplicatesInAnArray();
        obj.findDuplicates_1(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).forEach(c -> System.out.print(c + " "));
    }
}
