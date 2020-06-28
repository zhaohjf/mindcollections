package alg.zhj.campaign.week04.preview;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/6/28.
 */
public class FindContentChildren_455 {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                count++;
                si++;
                gi++;
            } else {
                si++;
            }
        }
        return count;
    }

    /**
     *
     *
     * @param g
     * @param s
     * @return
     */
    public int _findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; count < g.length && i < s.length; i++) {
            if (g[count] <= s[i]) {
                count++;
            }
        }
        return count;
    }

}
