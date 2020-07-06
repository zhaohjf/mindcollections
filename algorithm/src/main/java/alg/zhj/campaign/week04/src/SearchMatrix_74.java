package alg.zhj.campaign.week04.src;

/**
 * Created by zhaohongjie on 2020/7/4.
 */
public class SearchMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length <= 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
