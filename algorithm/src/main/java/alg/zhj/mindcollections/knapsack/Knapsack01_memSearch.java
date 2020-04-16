package alg.zhj.mindcollections.knapsack;

/**
 * 记忆化搜索
 * 用数组保存之前计算过的子问题，避免重复计算
 *
 * Created by zhaohongjie on 2020/4/16.
 */
public class Knapsack01_memSearch {

    private static int[][] memo;

    /**
     * 背包问题-递归
     *
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param index 当前待选择物品索引
     * @param capacity 背包当前剩余容量
     * @return
     */
    private static int solveKS(int[] w, int[] v, int index, int capacity) {

        // 如果当前物品已被选完，或容量已满，返回价值为0；
        if (index < 0 || capacity <= 0) {
            return 0;
        }

        if (memo[index][capacity] != 0) {
            return memo[index][capacity];
        }

        // 不放第index物品时的价值
        int res = solveKS(w, v, index - 1, capacity);

        // 放置第index物品时的价值
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }

        memo[index][capacity] = res;
        return res;
    }

    public static int knapsack(int[] w, int[] v, int C) {
        int size = w.length;
        return solveKS(w, v, size - 1, C);
    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        int c = 5;
        memo = new int[w.length][c + 1];
        System.out.println(knapsack(w, v, c));
    }
}
