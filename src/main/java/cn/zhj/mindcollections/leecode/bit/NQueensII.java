package cn.zhj.mindcollections.leecode.bit;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 *
 * Created by zhaohongjie on 2019/2/17.
 */
public class NQueensII {

    int count = 0;

    public int totalNQueens(int n) {

        if (n < 1) {
            return 0;
        }

        dfs(n, 0, 0, 0, 0);

        return count;
    }

    /**
     * ((1 << n) - 1) 作用——int有32位，但我们实际用的只有后N位，用1来表示可以放置皇后的位置。与上 ((1 << n) - 1) 表达式的作用就是
     * 将int取反后不需要的高位1重置为0，保证只有后N位的有效位。
     *
     * 在cols，na，pie中，根据每位是否为1来判断该位置是否可以放置皇后，0 可以放；1 不可以放置。
     * —— cols | p，在某一位置放置皇后，更新cols，将对应位置1；
     * —— (pie | p) << 1，撇方向也不可以再放置皇后，对应位置为放置皇后位的左下方，因此，与上放置皇后位置后要向左移动一位。
     *    如果 放置皇后位置为：
     *    0 0 1 0
     *    1 0 0 0 【cols -> 0010 = 2, pie -> 0100 = 4, na -> 0001 = 1；空闲位置 0111】
     *            【cols -> 1010, pie -> 11000, na -> 0100; 空闲位置 11110】
     *    0 0 0 1
     *    这里需要解释下，当第一个皇后放在位置0010上时，每二行的撇中皇后可放的位置为0100，第三行中则为1000；可以看出撇捺在不同行左右移
     *    的次数是不同的，确保的就是原有撇捺不可放置的信息在下一行时仍能准确表达。
     */
    private void dfs(int n, int row, int cols, int pie, int na) {

        if (row >= n) {
            count++;
            return;
        }

        int bits = (~(cols | na | pie)) & ((1 << n) - 1);

        while (bits != 0) {
            int p = bits & -bits;
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
            bits = bits & (bits - 1);
        }
    }

    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(4));
    }
}
