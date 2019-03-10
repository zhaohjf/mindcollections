package cn.zhj.mindcollections.leecode2.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * Created by zhaohongjie on 2019/3/8.
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, new ArrayList<>(), nums, new boolean[nums.length], 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] exists, int start) {

        list.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {

            /**
             * 当i被使用过为true时，当然不可以再次使用
             *
             * 当i为false时，如果它的前一元素同它相等且这个元素没有被使用过，continue
             *            ，如果它的前一元素同它相等且这个元素已经被使用过，可以使用这个元素
             *
             * 1， 2，    2
             *   true  false
             * 这种情况下，第二个2是可用的
             *
             * 1，  2，    2
             *   false  false
             * 都为false情况下，第二个2不可用，因为这个就会有重复
             *
             * 也就是说，对于排序后数组中值相等的元素，只有前一个的被使用了，后面那个才可以被使用。
             */
            if (exists[i] || (i > 0 && nums[i] == nums[i - 1] && exists[i - 1] == false)) {
                continue;
            }

            tempList.add(nums[i]);
            exists[i] = true;
            dfs(list, tempList, nums, exists, i + 1);
            tempList.remove(tempList.size() - 1);
            exists[i] = false;
        }
    }

    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        List<List<Integer>> lists = subsets.subsetsWithDup(new int[]{1,2,2,2});

        lists.forEach(list -> {
            list.forEach(c -> System.out.print(c + ","));
            System.out.println();
        });
    }

}
