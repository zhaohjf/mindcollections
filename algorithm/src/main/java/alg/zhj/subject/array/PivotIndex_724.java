package alg.zhj.subject.array;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 * <p>
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *  
 * <p>
 * 说明：
 * <p>
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by zhaohongjie on 2020/8/29.
 */
public class PivotIndex_724 {

    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        int preSum = 0, postSum = 0;
        while (i < j) {
            if (Math.abs(preSum) <= Math.abs(postSum)) {
                preSum += nums[i];
                i++;
            } else {
                postSum += nums[j];
                j--;
            }
        }
        if (preSum == postSum) {
            return i;
        } else {
            return -1;
        }
    }

    public int _pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int n : nums) sum += n;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] a = {-1, -1, -1, -1, -1, 0};
        int[] a = {-1, -1, -1, -1, 0, 1};
        int index = pivotIndex(a);
        System.out.print(index);
    }
}
