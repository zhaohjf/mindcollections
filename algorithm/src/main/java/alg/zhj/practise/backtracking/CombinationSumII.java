package alg.zhj.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), candidates, target, new boolean[candidates.length], 0);

        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, int candidates[], int target, boolean[] exists, int index) {

        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        dfs(ans, temp, candidates, target, exists, index + 1);
        if (target >= candidates[index]) {
            if (!(exists[index] || (index > 0 && candidates[index] == candidates[index - 1] && exists[index - 1] == false))) {
                temp.add(candidates[index]);
                exists[index] = true;
                dfs(ans, temp, candidates, target - candidates[index], exists, index);
                exists[index] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).forEach(x -> System.out.println(x));
    }
}
