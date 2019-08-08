package alg.zhj.mindcollections.leecode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * Created by zhaohongjie on 2019/3/12.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Integer max = 0, index = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max.intValue() < entry.getValue().intValue()) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }

        return index;
    }

    // =================================================================================================

    public int majorityElement_1(int[] nums) {
        int maj = 0, count = 0;
        for (int num : nums) {
            if (count == 0) maj = num;
            if (maj == num) count++;
            else count--;
        }
        return maj;
    }

    // =================================================================================================

    // =================================================================================================

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(new int[]{3, 2, 3}));
        System.out.println(obj.majorityElement_1(new int[]{3, 2, 3}));
    }

}
