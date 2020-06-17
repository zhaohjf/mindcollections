package alg.zhj.campaign.week01;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/6/11.
 */
public class ArrayRotate_189 {

    /**
     * 注意do while 和 while do 区别
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return;
        }

        k = k % nums.length;

        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (i != current);
        }
    }
    
    /**
     * 解法2，创建一个新数组，按(i + k) % nums.length，将数据转移到新数组中
     * 新数组就是最后的解
     *
     * 不过这个方案的空间复杂度就比较高了
     **/
    
    /**
     * 方案3，通过反转来实现，需要三次反转
     *
     **/
    public static void  _reverse_rotate(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return;
        }

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {

        if (end < start) {
            return;
        }

        while (start < end) {
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;
            end--;
        }
    }

    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        ArrayRotate_189 obj = new ArrayRotate_189();
        obj.rotate(a, 3);
        Arrays.stream(a).forEach(System.out::print);
    }
}
