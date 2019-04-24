package alg.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * Created by zhaohongjie on 2019/1/31.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    /**
     * 使用数组效率会高些
     *
     * 该算法只适用于没有重复数字的情况下
     *
     * @param result
     * @param temp
     * @param nums
     * @param level
     */
    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int level) {
        if (level == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            dfs(result, temp, nums, level + 1);
            temp.remove(temp.size() - 1);
        }
    }

    List<List<Integer>> perlist = new ArrayList<>();

    public List<List<Integer>> permute_2(int[] nums) {
        permute(nums, 0);
        return perlist;
    }

    public void permute(int[] nums, int start) {
        if (start == nums.length - 1) {
            perlist.add(array2list(nums));
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, start + 1);
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public List array2list(int[] array) {
        List list = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute_2(new int[]{1,1,3});

        permute.forEach(list -> {
            list.forEach(c -> System.out.print(c + ","));
            System.out.println();
        });
    }
}
