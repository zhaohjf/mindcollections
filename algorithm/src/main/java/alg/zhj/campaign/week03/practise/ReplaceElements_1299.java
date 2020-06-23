package alg.zhj.campaign.week03.practise;

/**
 * 逆序遍历
 *
 * Created by zhaohongjie on 2020/6/23.
 */
public class ReplaceElements_1299 {

    /**
     * 大佬代码
     *
     * @param A
     * @return
     */
    public int[] replaceElements(int[] A) {
        for (int i = A.length - 1, mx = -1; i >= 0; --i)
            mx = Math.max(A[i], A[i] = mx);
        return A;
    }

    /**
     * 我的啰嗦代码
     *
     * @param arr
     * @return
     */
    public int[] _replaceElements(int[] arr) {

        if (arr == null) {
            return new int[0];
        }

        int size = arr.length;
        int[] ans = new int[size];

        int rightMost = arr[size - 1];
        ans[size - 1] = -1;
        for (int i = size - 2; i >= 0; i--) {
            ans[i] = rightMost;
            if (arr[i] > rightMost) {
                rightMost = arr[i];
            }
        }

        return ans;
    }
}
