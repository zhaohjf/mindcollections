package alg.zhj.campaign.week01;

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
    
    /**
     * 交换元素，少遍历一次数组；但多了交换操作，和上面方法比性能应该是差不多的
     **/
    public static void _moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }

        int anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[anchor] = nums[anchor] ^ nums[i];
                nums[i] = nums[anchor] ^ nums[i];
                nums[anchor] = nums[anchor] ^ nums[i];
                anchor++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 0, 3};
        MoveZeroes_283 obj = new MoveZeroes_283();
        obj.moveZeroes(a);
        Arrays.stream(a).forEach(System.out::print);
    }
}
