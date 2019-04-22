package cn.zhj.mindcollections.leecode2.string;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/submissions/ 中文版
 *
 *
 * Created by zhaohongjie on 2019/4/22.
 */
public class LongestPalindromicSubstring {

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
