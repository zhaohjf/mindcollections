package alg.zhj.mindcollections.leecode2.dynamic;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by zhaohongjie on 2020/6/1.
 */
public class CanJump {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int length = nums.length;
        int rightMost = 0;
        for (int i = 0; i < length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 4};
        CanJump obj = new CanJump();
        System.out.println(obj.canJump(a));
    }
}
