package alg.zhj.mindcollections.interview.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 *
 * Created by zhaohongjie on 2019/4/7.
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

//        int[] count = new int[nums.length + 1];
//
//        for (int i = 0; i < count.length; i++) {
//            count[i] = -1;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (count[nums[i]] == -1) {
//                count[nums[i]] = i;
//            } else if (count[nums[i]] != -1 && i - count[nums[i]] > k) {
//                count[nums[i]] = i;
//            } else {
//                return true;
//            }
//        }
//
//        return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else if (i - map.get(nums[i]) > k) {
                map.put(nums[i], i);
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate_1(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]&&(j-i)<=k){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII obj = new ContainsDuplicateII();
        System.out.print(obj.containsNearbyDuplicate_1(new int[]{3,1,2,3,4}, 4));

    }
}
