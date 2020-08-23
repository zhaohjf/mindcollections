package alg.zhj.subject.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * <p>
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by zhaohongjie on 2020/8/19.
 */
public class FindShortestSubArray_697 {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        int maxCount = 0;
        for (Integer key : count.keySet()) {
            if (count.get(key) > maxCount) {
                maxCount = count.get(key);
                max = key;
            }
        }
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                begin = i;
                break;
            }
        }
        int end = 0;
        for (int i = begin; i < nums.length; i++) {
            if (nums[i] == max) {
                end = i;
            }
        }
        return end - begin + 1;
    }

    /**
     * 应该返回2
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.print(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
