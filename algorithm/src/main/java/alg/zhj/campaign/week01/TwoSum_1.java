package alg.zhj.campaign.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaohongjie on 2020/6/12.
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])) {
                return new int[]{i, index.get(target - nums[i])};
            } else {
                index.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
