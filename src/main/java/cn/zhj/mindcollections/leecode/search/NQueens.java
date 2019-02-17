package cn.zhj.mindcollections.leecode.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/
 *
 * Created by zhaohongjie on 2019/1/30.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        if (n < 1) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        dfs_2(new String[n], 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], result);

        result.forEach(array -> {
            for (String str : array) {
                System.out.println(str);
            }
            System.out.println();
            System.out.println("======");
        });

        return result;
    }

    /**
     * 将放置皇后的每一个位置看作是坐标系第四象限中一个点（横轴为j，纵轴为i）（在坐标系里，i为负数、j为正数），且两点可以确定一条直线！
     *
     * 实际上，代码中的i,j都为正数
     *
     * 向左倾斜（形如 /）的线性函数为 x - y = c，转换后 j - (-i) = i + j = c
     * 向右倾斜（形如 \）的线性函数为 x + y = c，转换后 j + (-i) = j - i = c
     *
     * 假设在一个点（1，0）上放置了一个皇后，那么其它位置满足 i + j = 1 + 0 = 0 的点都在皇后的左斜线上，都可以被攻击到，返回亦然
     *
     * @param n
     * @param row
     * @param currentStat
     */
    private void dfs(int n, int row, String currentStat, Set<Integer> cols, Set<Integer> pie, Set<Integer> na, List<String> result) {

        if (row >= n) {
            // 递归结束
            result.add(currentStat);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }

            cols.add(col);
            pie.add(row + col);
            na.add(row - col);

            dfs(n, row + 1, currentStat + "," + col, cols, pie, na, result);

            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }

    }

    /**
     * 使用数组（2ms）要比Set（25ms）运行速度快
     *
     * 使用数组需要注意数组下标不能为负数，这里通过 + n 来处理。
     *
     * @param board
     * @param row
     * @param cols
     * @param pie
     * @param na
     * @param result
     */
    private void dfs_2(String[] board, int row, boolean[] cols, boolean[] pie, boolean[] na, List<List<String>> result) {

        if (row >= board.length) {
            result.add(Arrays.asList(board.clone()));
            return;
        }

        for (int col = 0; col < board.length; col++) {

            int iPie = row + col;
            // 防止数组下标为负数
            int iNa = row - col + board.length;

            if (cols[col] || pie[iPie] || na[iNa]) {
                continue;
            }

            char[] line = new char[board.length];
            Arrays.fill(line, '.');
            line[col] = 'Q';
            board[row] = new String(line);

            cols[col] = true;
            pie[iPie] = true;
            na[iNa] = true;

            dfs_2(board, row + 1, cols, pie, na, result);

            cols[col] = false;
            pie[iPie] = false;
            na[iNa] = false;
        }
    }

    Integer result = 0;

    public int totalNQueens(int n) {

        if (n < 1) {
            return result;
        }

        dfs_3(n, 0, new boolean[n], new boolean[2*n], new boolean[2*n]);

        return result;
    }

    /**
     * 参数result被注释掉，改为使用类成员变量的原因是：
     * 对result多使用的是赋值操作，递归过程中这个值总是会被覆盖（也就是它的引用经常会变）；像上面List这种在递归过程中引用不会发生变化的实例，
     * 就不存在这种问题了。
     *
     * @param n
     * @param row
     * @param cols
     * @param pie
     * @param na
     */
    private void dfs_3(int n, int row, boolean[] cols, boolean[] pie, boolean[] na/*, Integer result*/) {

        if (row >= n) {
            result++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int iPie = row + col;
            int iNa = row - col + n;

            if (cols[col] || pie[iPie] || na[iNa]) {
                continue;
            }

            cols[col] = true;
            pie[iPie] = true;
            na[iNa] = true;

            dfs_3(n, row + 1, cols, pie, na);

            cols[col] = false;
            pie[iPie] = false;
            na[iNa] = false;
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        //nQueens.solveNQueens(4);

        int i = nQueens.totalNQueens(4);
        System.out.println(i);
    }
}
