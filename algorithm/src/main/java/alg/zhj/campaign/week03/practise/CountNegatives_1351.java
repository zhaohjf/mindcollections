package alg.zhj.campaign.week03.practise;

/**
 * Created by zhaohongjie on 2020/6/23.
 */
public class CountNegatives_1351 {

    public int _countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c; // there are n - c negative numbers in current row.
            }else {
                ++c;
            }
        }
        return cnt;
    }

    /**
     * 题目前提是无论按行还是按列，都是非单调递增的，所以下面解法可以使用
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = 0, c = n - 1, cnt = 0;
        while (r < m && c >= 0) {
            if (grid[r][c] < 0) {
                --c;
                cnt += m - r; // there are m - r negative numbers in current column.
            }else {
                ++r;
            }
        }
        return cnt;
    }

    /**
     * 我的，二分查找思路
     *
     * @param grid
     * @return
     */
    public int _mine_countNegatives(int[][] grid) {

        if (grid == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            count += binary(grid[i], 0, grid[i].length - 1);
        }

        return count;
    }

    private int binary(int[] row, int left, int right) {
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] < 0) {
                right = mid - 1;
                pos = mid;
            } else {
                left = mid + 1;
            }
        }
        if (pos != -1) {
            return row.length - pos;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] a = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        CountNegatives_1351 obj = new CountNegatives_1351();
        System.out.println(obj.countNegatives(a));
    }
}
