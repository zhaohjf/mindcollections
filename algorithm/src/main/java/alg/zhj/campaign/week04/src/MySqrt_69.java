package alg.zhj.campaign.week04.src;

/**
 * Created by zhaohongjie on 2020/7/2.
 */
public class MySqrt_69 {

    public int mySqrt_0703(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1;
        int r = x/2;
        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (mid > x /mid) {
                // ans = mid; // 向上取整放这里
                r = mid - 1;
            } else {
                ans = mid; // 向下取整放这里
                l = mid + 1;
            }
        }
        return ans;
    }
}
