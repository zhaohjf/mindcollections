package alg.zhj.practise.arraysohard.doublepointer;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class MaxArea {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l <= r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
