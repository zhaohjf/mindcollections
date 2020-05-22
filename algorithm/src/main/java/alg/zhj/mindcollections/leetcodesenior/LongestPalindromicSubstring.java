package alg.zhj.mindcollections.leetcodesenior;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/ 中文版
 * https://leetcode.com/problems/longest-palindromic-substring 英文版
 *
 * 动态规则解决最大回文子串问题
 *
 * Created by zhaohongjie on 2019/4/22.
 */
public class LongestPalindromicSubstring {

    /**
     * DP解法
     *
     * 运行时间 32ms
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s){

        String palindrome = "";

        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {

            /**
             * ABA 型
             * 以中间一个字符为轴
             */
            String palindrome1 = getLongestPalindrome(sc, i, i);

            if (palindrome1.length() > palindrome.length()) {
                palindrome = palindrome1;
            }

            /**
             * BB 型
             * 以两个字符之间的间隙为轴
             */
            String palindrome2 = getLongestPalindrome(sc, i, i + 1);

            if (palindrome2.length() > palindrome.length()) {
                palindrome = palindrome2;
            }

        }

        return palindrome;
    }

    /**
     * ABA型时 l == r
     * BB型时 r = l + 1
     *
     * 以轴为中心，向两侧扩散；对比发现最长回文字符串
     *
     * @param sc
     * @param l 左轴
     * @param r 右轴
     * @return
     */
    private String getLongestPalindrome(char[] sc, int l, int r) {

        while (l >= 0 && r < sc.length && sc[l] == sc[r]) {
            l--;
            r++;
        }

        return String.valueOf(sc).substring(l + 1, r);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.print(obj.longestPalindrome("bbbab"));
    }

    /**
     * 性能有极大提升，从30多ms提升到2ms
     *
     * 运行时间 2ms
     *
     * 剪枝：跳过连续相同字符
     *
     * @param s
     * @return
     */
    public String longestPalindrome_2(String s) {

        if (s == null || s.equals("")) {
            return s;
        }

        char[] c = s.toCharArray();
        int[] r = new int[2];
        for (int i = 0; i < c.length; i++) {
            i = longest(i, r, c);
        }

        return s.substring(r[0], r[1] + 1);
    }

    /**
     * 以low为中心轴
     *
     * 剪枝：c[low] = c[low]，则视low与low + 1整体为中心点
     *
     * @param low 当前为轴的点
     * @param r 保存回文子串的开始与结束位置
     * @param c 原始字符数组
     *
     * @return ans ans >= low 对于有多个连接相同字符的情况，ans返回值有助于减少上层遍历次数
     */
    public int longest(int low, int[] r, char[] c) {

        int high = low;
        while (high < c.length - 1 && c[low] == c[high + 1]) {
            ++high;
        }

        int ans = high;
        while (low > 0 && high < c.length - 1 && c[low - 1] == c[high + 1]) {
            --low;
            ++high;
        }

        if (high - low > r[1] - r[0]) {
            r[1] = high;
            r[0] = low;
        }

        return ans;
    }
}
