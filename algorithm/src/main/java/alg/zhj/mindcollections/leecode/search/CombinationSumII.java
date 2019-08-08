package alg.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * Created by zhaohongjie on 2019/2/3.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, new ArrayList<Integer>(), candidates, target, new boolean[candidates.length], 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int candidates[], int target, boolean[] exists, int num) {

        if (target == 0) {
            result.add(temp);
            return;
        }

        if (target < candidates[0]) {
            return;
        }

        for (int i = num; i < candidates.length && target >= candidates[i]; i++) {

            if (exists[i] || (i > 0 && candidates[i] == candidates[i - 1] && exists[i - 1] == false)) {
                continue;
            }

            /**
             * 每次递归都生成一个新的temp List，每次递归也都是维护自己单独的那份temp List，这样，会比较浪费内存；
             * 优点是：回溯时不用重置temp List。
             *
             * 推荐做法：维护一个temp List，回溯时，要重置状态，节省很多空间。
             *
             */
            ArrayList<Integer> list = new ArrayList<>(temp);
            list.add(candidates[i]);

            exists[i] = true;
            dfs(result, list, candidates, target - candidates[i], exists, i + 1);
            exists[i] = false;
        }
    }

    public static void main(String[] args) {

        CombinationSumII combinationSumII = new CombinationSumII();

        int[] candidates = {2, 5, 2, 1, 2};
        List<List<Integer>> lists = combinationSumII.combinationSum2(candidates, 5);

        lists.forEach(list -> {
            list.forEach(c -> System.out.print(c));
            System.out.println();
        });
    }
}
