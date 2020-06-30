package alg.zhj.campaign.week04.practise;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class OddCells_1252 {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] ans = new int[n][m];
        if (indices == null) {
            return 0;
        }
        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];
            for (int mi = 0; mi < m; mi++) {
                ans[row][mi] += 1;
            }
            for (int ni = 0; ni < n; ni++) {
                ans[ni][col] += 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((ans[i][j] & 1) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public int _oddCells(int n, int m, int[][] indices) {
        boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true;
            oddCols[idx[1]] ^= true;
            cntRow += oddRows[idx[0]] ? 1 : -1;
            cntCol += oddCols[idx[1]] ? 1 : -1;
        }
        // return m * cntRow + n * cntCol - 2 * cntRow * cntCol;
        return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
    }

    public static void main(String[] args) {
        int[][] indices = {{0,1},{1,1}};
        OddCells_1252 obj = new OddCells_1252();
        System.out.println(obj._oddCells(2, 3, indices));
    }
}
