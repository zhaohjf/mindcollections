package alg.zhj.mindcollections.leetcodesenior;

/**
 * https://leetcode-cn.com/problems/prison-cells-after-n-days
 * 位运算解决 N天后的监狱问题
 *
 * Created by zhaohongjie on 2019/5/9.
 */
public class PrisonCellsAfterNDays {

    /**
     * 是有周期性的
     *
     * @param cells
     * @param N
     * @return
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        int num = 0;
        for (int i = 0; i < cells.length; i++) {
            num <<= 1;
            num |= cells[i];
        }
        num = change(num);
        int times = (N - 1) % 14;
        for (int i = 0; i < times; i++) {
            num = change(num);
        }
        int[] res = new int[cells.length];
        for (int i = cells.length - 1; i >= 0; i--) {
            res[i] = num & 1;
            num >>= 1;
        }
        return res;
    }

    private int change(int pre) {
        int mask = 126; // 126 = 0111 1110
        int left = pre << 1;
        int right = pre >> 1;
        int res = (~ (left ^ right)) & mask;
        return res;
    }

    public static void main(String[] args) {
        PrisonCellsAfterNDays obj = new PrisonCellsAfterNDays();
        int[] res = obj.prisonAfterNDays(new int[]{0, 0, 1, 1, 0, 0, 0, 0}, 1);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    /**
     * 超时
     */
    /**public int[] prisonAfterNDays(int[] cells, int N) {

        for (int i = 0; i < N; i++) {
            int[] next = change(cells);
            cells = next;
        }

        return cells;
    }

    private int[] change(int[] cells) {
        int[] curr = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            curr[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }

        return curr;
    }*/
}
