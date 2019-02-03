package cn.zhj.mindcollections.leecode.search;

import cn.zhj.mindcollections.java.InnerClassAnalysis;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * Created by zhaohongjie on 2019/2/3.
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<Integer>(), k, n, 1);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int k, int n, int num) {

        if (n == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = num; i <= 9 && n >= i; i++) {

            temp.add(i);
            dfs(result, temp, k, n - i, i + 1);
            temp.remove((Integer) i);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        List<List<Integer>> lists = combinationSumIII.combinationSum3(3, 7);

        lists.forEach(list -> {
            list.forEach(c -> System.out.print(c));
            System.out.println();
        });
    }
}
