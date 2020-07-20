package alg.zhj.campaign.week06.practise;

/**
 * Created by zhaohongjie on 2020/7/9.
 */
public class MinDeletionSize_944 {

    public int minDeletionSize(String[] A) {
        int m = A.length;
        int n = A[0].length();
        char[][] c = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = A[i].charAt(j);
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (c[i][j] < c[i - 1][j]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinDeletionSize_944 obj = new MinDeletionSize_944();
        int ans = obj.minDeletionSize(new String[]{"cba", "daf", "ghi"});
        System.out.println(ans);
    }
}
