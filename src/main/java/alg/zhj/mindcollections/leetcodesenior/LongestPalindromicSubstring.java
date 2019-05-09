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

    private String getLongestPalindrome(char[] sc, int l, int r) {

        while (l >= 0 && r < sc.length && sc[l] == sc[r]) {
            l--;
            r++;
        }

        return String.valueOf(sc).substring(l + 1, r);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.print(obj.longestPalindrome("babad"));
    }
}
