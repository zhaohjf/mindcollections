package alg.zhj.mindcollections.leecode.array;

//Given an array of integers and an integer k, find out whether there are two distinct indices i and
//j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组
 * 寻找下标i和j，满足i!=j and nums[i] = nums[j] and |i -j| < k
 *
 * Created by zhaohongjie on 2018/10/16.
 */
public class ContainsDuplicatesII {

    /**
     * 利用Map数据结构
     * 遍历数组的同时，记录已经遍历数组中下标与值的对应关系；
     *
     * 若后续遍历到的值在Map中存在，则取出其下标，和当前遍历下标计算绝对值，如果小于k，就返回true;
     * 若始终没发现这样的数，则返回false
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if(map.containsKey(current) && i - map.get(current) <= k) {
                return true;
            } else {
                map.put(current, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(a, 12));
    }
}
