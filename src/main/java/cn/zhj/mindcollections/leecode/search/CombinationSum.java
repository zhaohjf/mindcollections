package cn.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * Created by zhaohongjie on 2019/1/29.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);

        return listAll;
    }

    /**
     * 我的难点：找到一个值，若小于target，记录这个值，并用target减去这个值，成为新的target；当target == 0时，退出。
     *
     * 这里使用了剪枝——当前target小于侯选数组（已排序）第一个值时，说明不再可能有匹配的数字，直接退出；这样可以减少许多的计算量。
     *
     * @param listAll
     * @param tmp
     * @param candidates
     * @param target
     * @param num
     */
    public void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {

        if (target == 0) {
            listAll.add(tmp);
            return;
        }

        /**
         * 剪枝
         *
         */
        if (target < candidates[0]) {
            return;
        }

        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {

            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);

            find(listAll, list, candidates, target - candidates[i], i);
        }
    }

    public static void main(String[] args) {
        int[] param = {10, 1, 2, 7, 6, 1, 5};
        CombinationSum obj = new CombinationSum();
        List<List<Integer>> lists = obj.combinationSum(param, 8);

        lists.forEach(list -> {
            list.forEach(c -> System.out.print(c));
            System.out.println();
        });
    }
}
