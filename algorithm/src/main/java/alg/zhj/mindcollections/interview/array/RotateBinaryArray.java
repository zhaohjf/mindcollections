package alg.zhj.mindcollections.interview.array;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * Created by zhaohongjie on 2019/4/6.
 */
public class RotateBinaryArray {

    public void rotate(int[][] matrix) {

        if (matrix == null) {
            return;
        }

        int tR = 0;
        int tC = 0;
        int dR = matrix.length -1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {

        int times = dC - tC;
        int tmp = 0;

        for (int i = 0; i < times; i++) {
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;

            print(matrix);
        }
    }

    public static void main(String[] args) {

        RotateBinaryArray obj = new RotateBinaryArray();
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        obj.print(array);
        obj.rotate(array);

    }

    private void print(int[][] matrix) {
        for (int[] a : matrix) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
