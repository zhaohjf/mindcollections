package alg.zhj.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs_backtracking(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }

    /**
     *
     * @param ans
     * @param tmp
     * @param candidates
     * @param target
     * @param index
     */
    public void find(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int index) {

        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        // 剪枝
        // 前提是candidates要排序
        if (target < candidates[0]) {
            return;
        }

        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            ArrayList<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            find(ans, list, candidates, target - candidates[i], i); // 可以重复选择
        }
    }

    /**
     * ==================================================================================================================
     */

    public void dfs_backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        dfs_backtracking(ans, tmp, candidates, target, index + 1);
        if (candidates[index] <= target) {
            tmp.add(candidates[index]);
            dfs_backtracking(ans, tmp, candidates, target - candidates[index], index);
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * ==================================================================================================================
     */

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        obj.combinationSum(new int[]{2, 3, 6, 7}, 7).forEach(x -> System.out.println(x));
    }
}
