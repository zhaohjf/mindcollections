package alg.zhj.practise.string;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String palindrome = "";
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            String palindrome1 = getLongestPalindrome(sc, i, i);
            if (palindrome1.length() > palindrome.length()) {
                palindrome = palindrome1;
            }
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

    }
}
