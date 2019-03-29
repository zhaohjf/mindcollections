package cn.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 *
 * Created by zhaohongjie on 2019/1/31.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        if (n <= 0 || k > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), n, k, 1);

        return result;
    }

    /**
     * 千辛万苦 看了别人的代码才写出来的=。=~~~
     *
     * @param result
     * @param temp
     * @param n
     * @param k
     * @param level
     */
    private void dfs(List<List<Integer>> result, List<Integer> temp, int n, int k, int level) {

        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        /**
         * 这里的 i <= n - k + 1 很神奇
         *
         * 具体原理还说不清楚，能够减少遍历次数，相当于是一次剪枝
         *
         */
        for (int i = level; i <= n - k + 1; i++) {
            temp.add(i);
            dfs(result, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine_3(int n, int k) {
        if (n < 1 || n < k) {
            return result;
        }
        combine(n, k, 1, new ArrayList<>());
        return result;
    }

    /**
     * 使用删除list最后一个元素的方法来实现回溯，牛逼
     *
     * @param n
     * @param k
     * @param index
     * @param temp
     */
    private void combine(int n, int k, int index, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= n-k+1; i++) {
            temp.add(i);
            combine(n, k - 1, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine_2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, new ArrayList<>());
        return res;
    }

    /**
     * 这个算法没有循环，看起来的会比较简洁些；
     *
     * 缺点可能就是递归深度比较大。同时，也表示递归可以在逻辑上替换循环
     *
     * @param res
     * @param n
     * @param k
     * @param path
     */
    private void dfs(List<List<Integer>> res, int n, int k, ArrayList<Integer> path) {
        if (n < 0) return;
        if (k < 0) return;
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(n);
        dfs(res, n - 1, k - 1, path);
        path.remove(path.size() - 1);
        dfs(res, n - 1, k, path);
    }


    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine_2(4, 3);

        combine.forEach(list -> {
            list.forEach(c -> System.out.print(c + ","));
            System.out.println();
        });
    }
}
