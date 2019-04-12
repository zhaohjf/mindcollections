package cn.zhj.mindcollections.interview.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by zhaohongjie on 2019/4/8.
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        //Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < i + k && j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) <= t) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 分桶方式：数组值 除以 (t + 1)，所以，是通过数组中每个值与(t + 1)的倍数来进行公桶的。注：这里 t + 1 主要是为了预防 t=0 的情况。
     *
     * 因此，在同一个桶内的数相差肯定是小于t的；同时，相邻的上一个和下一个桶内的数组也有可能与当前数相差 < t。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate_1(int[] nums, int k, int t) {

        if (k < 1 || t < 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);

            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;

            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }

            map.put(bucket, remappedNum);
        }

        return false;
    }

    /**
     *
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate_2(int[] nums, int k, int t) {

        // 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }

            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicateIII obj = new ContainsDuplicateIII();
        System.out.print(obj.containsNearbyAlmostDuplicate_1(new int[]{1,5,9,1,5,9}, 2, 3));
    }

}
