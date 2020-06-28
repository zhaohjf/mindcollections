package alg.zhj.campaign.week03.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/28.
 */
public class Permute_46 {

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

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Permute_46 obj = new Permute_46();
        System.out.println(obj.permute(a));
    }
}
