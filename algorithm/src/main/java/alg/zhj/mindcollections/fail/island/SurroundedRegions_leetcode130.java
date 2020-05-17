package alg.zhj.mindcollections.fail.island;

/**
 * 思路，标记从边界出发，包含0的连通分量。反过来想问题
 *
 * 把不需要变换的标记出来，剩下的就都是需要变换的
 *
 * Created by zhaohongjie on 2020/5/17.
 */
public class SurroundedRegions_leetcode130 {

    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    /**
     * bug
     * if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X')
     * == 'X' 才退出，实际上 == 'X' or 'G' 才是退出条件
     *
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'G';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        //char[][] a = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] a = {{'O','O'},{'O','O'}};
        SurroundedRegions_leetcode130 obj = new SurroundedRegions_leetcode130();
        obj.solve(a);
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
