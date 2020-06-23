package alg.zhj.campaign.week03.practise;

/**
 * Created by zhaohongjie on 2020/6/23.
 */
public class BalancedStringSplit_1221 {

    /**
     * 大佬的代码
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) ++res;
        }
        return res;
    }

    /**
     * 我的代码，臭长
     *
     * @param s
     * @return
     */
    public int _balancedStringSplit(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        int tmp = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'L') {
                tmp--;
            }
            if (c[i] == 'R') {
                tmp++;
            }
            if (tmp == 0) {
                count++;
            }
        }

        return count;
    }
}
