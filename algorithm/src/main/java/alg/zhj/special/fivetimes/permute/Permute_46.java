package alg.zhj.special.fivetimes.permute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/27.
 */
public class Permute_46 {

    /**
     * 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(nums, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums, ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
