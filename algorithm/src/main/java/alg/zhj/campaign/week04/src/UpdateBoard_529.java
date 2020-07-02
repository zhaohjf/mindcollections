package alg.zhj.campaign.week04.src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2020/7/1.
 */
public class UpdateBoard_529 {

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 相邻位置
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    /**
     * BFS
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] _updateBoard(char[][] board, int[] click) {
        int r = board.length;
        int c = board[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(click[0], click[1]));
        while(!queue.isEmpty()) {
            Node top = queue.poll();
            int x = top.x;
            int y = top.y;
            if (board[x][y] == 'E') { // 如果当前为E，才进行判断是否要递归相邻结点
                board[x][y] = 'B';
                int count = judge(board, r, c, x, y);
                if (count == 0) { // 如果为0，则进行递归（感觉这里可以与jude进行优化，但是反而时间增加了，以后再优化吧==）
                    for (int i = 0; i < 8; i++) {
                        int newX = x + dx[i];
                        int newY = y + dy[i];
                        if (newX < 0 || newX >= r || newY < 0 || newY >= c) {
                            continue;
                        }
                        queue.offer(new Node(newX, newY));
                    }
                } else { // 如果不为0，则不加入队列，同时更新当前结点的值为地雷数量
                    board[x][y] = (char) (count + '0');
                }
            } else if (board[x][y] == 'M') { // 如果当前为M，则只更新当前结点
                board[x][y] = 'X';
            }
        }
        return board;
    }

    /**
     * DFS
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length <= 0) {
            return board;
        }
        int m = board.length;
        int n = board[0].length;

        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }

        dfs(board, m, n, i, j);
        return board;
    }

    private void dfs(char[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'E') {
            return;
        }
        board[i][j] = 'B';
        int count = judge(board, m, n, i, j);
        if (count > 0) {
            board[i][j] = (char) (count + '0');
        } else {
            for (int x = 0; x < 8; x++) {
                dfs(board, m, n, i + dx[x], j + dy[x]);
            }
        }
    }

    private int judge(char[][] board, int m, int n, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                continue;
            }
            count += board[newX][newY] == 'M' ? 1 : 0;
        }
        return count;
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        UpdateBoard_529 obj = new UpdateBoard_529();
        char[][] a = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        obj.updateBoard(a, new int[]{3, 0});

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
