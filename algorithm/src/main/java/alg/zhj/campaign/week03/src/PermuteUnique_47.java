package alg.zhj.campaign.week03.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/28.
 */
public class PermuteUnique_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        dfs(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> tmp, boolean[] exist) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (exist[i] || (i > 0 && nums[i - 1] == nums[i] && exist[i - 1] == false)) {
                continue;
            }
            tmp.add(nums[i]);
            exist[i] = true;
            dfs(nums, ans, tmp, exist);
            exist[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        PermuteUnique_47 obj = new PermuteUnique_47();
        System.out.print(obj.permuteUnique(a));
    }
}
