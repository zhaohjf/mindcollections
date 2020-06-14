package alg.zhj.mindcollections.campaign.week01;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/6/12.
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }

        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[prev++] = nums[i];
            }
        }

        while (prev < nums.length) {
            nums[prev++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 0, 3};
        MoveZeroes_283 obj = new MoveZeroes_283();
        obj.moveZeroes(a);
        Arrays.stream(a).forEach(System.out::print);
    }
}
