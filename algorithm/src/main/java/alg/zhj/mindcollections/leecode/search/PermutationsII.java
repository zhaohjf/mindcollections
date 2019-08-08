package alg.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * Created by zhaohongjie on 2019/2/1.
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        dfs(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);

        return result;
    }

    /**
     * 利用一个boolean数组来记录访问记录
     *
     * @param result
     * @param temp
     * @param nums
     * @param exists
     */
    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] exists) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (exists[i] || (i > 0 && nums[i] == nums[i - 1] && exists[i - 1] == false)) {
                continue;
            }
            temp.add(nums[i]);
            exists[i] = true;
            dfs(result, temp, nums, exists);
            temp.remove(temp.size() - 1);
            exists[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> lists = permutationsII.permuteUnique(new int[]{1,3,1});

        lists.forEach(list -> {
            list.forEach(c -> System.out.print(c + ","));
            System.out.println();
        });
    }
}
