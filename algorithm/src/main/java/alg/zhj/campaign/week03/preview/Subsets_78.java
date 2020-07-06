package alg.zhj.campaign.week03.preview;

import alg.zhj.special.fivetimes.collection.subset.SubsetsII;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * {@link alg.zhj.mindcollections.leecode2.backtracking.Subsets}
 * {@link SubsetsII}
 *
 * Created by zhaohongjie on 2020/6/21.
 */
public class Subsets_78 {

    /**
     * 递归回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i + 1); // i + 1 not start + 1
            temp.remove(temp.size() - 1);
        }
    }
}
