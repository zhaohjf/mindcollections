package cn.zhj.mindcollections.leecode.search;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-search
 *
 * Created by zhaohongjie on 2019/2/13.
 */
public class WordSearch {

    boolean flag = false;

    /**
     * 利用深度优先搜索遍历
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        if (board == null || board.length <= 0) {
            return false;
        }

        if (word == null) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        char[] wordChars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordChars[0] && dfs_improve(board, visited, i, j, wordChars, 0)) {
                    return true;
                }
            }
        }


        return false;
    }

    /**
     * 超出leecode的时间限制
     *
     * 原因：剪枝力度不够
     *
     * @param board
     * @param visited
     * @param x
     * @param y
     * @param word
     * @param count
     */
    private void dfs(char[][] board, boolean[][] visited, int x, int y, char[] word, int count) {

        // 确保后面逻辑能够正常运行
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        if (board[x][y] != word[count]) {
            return;
        }

        if (count == word.length - 1) {
            flag = true;
            return;
        }

        visited[x][y] = true;
        dfs(board, visited, x, y + 1, word, count + 1);
        dfs(board, visited, x, y - 1, word, count + 1);
        dfs(board, visited, x + 1, y, word, count + 1);
        dfs(board, visited, x - 1, y, word, count + 1);
        visited[x][y] = false;
    }

    /**
     * 四个方向的递归式，使用逻辑或连接起来。
     *
     * 最终结果是：只要有一个满足条件就会立即返回，不再继续做多余的操作。
     *
     * @param board
     * @param visited
     * @param x
     * @param y
     * @param word
     * @param count
     * @return
     */
    private boolean dfs_improve(char[][] board, boolean[][] visited, int x, int y, char[] word, int count) {

        // 确保后面逻辑能够正常运行
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] != word[count]) {
            return false;
        }

        if (count == word.length - 1) {
            return true;
        }

        visited[x][y] = true;
        boolean result = dfs_improve(board, visited, x, y + 1, word, count + 1)
                || dfs_improve(board, visited, x, y - 1, word, count + 1)
                || dfs_improve(board, visited, x + 1, y, word, count + 1)
                || dfs_improve(board, visited, x - 1, y, word, count + 1);
        visited[x][y] = false;

        return result;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        boolean result = wordSearch.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
        System.out.println(result);
    }
}
