package alg.zhj.practise.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    /**
     * 回溯算法
     * @param nums
     * @param ans
     * @param temp
     */
    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute obj = new Permute();
        List<List<Integer>> ans = new ArrayList<>();
        obj.backtrack(new int[]{1, 2, 3}, ans, new ArrayList<>());
        ans.forEach(x -> System.out.println(x));
    }
}
