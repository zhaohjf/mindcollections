package alg.zhj.practise.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        ans.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets obj = new Subsets();
        obj.subsets(nums).forEach(x -> System.out.println(x));
    }
}
