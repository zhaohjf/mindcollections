package alg.zhj.campaign.week06.src;

/**
 * Created by zhaohongjie on 2020/7/18.
 */
public class CountSubstrings_647 {

    public static int countSubstrings(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n -1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = j - i < 3 ? true : dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int _countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    int count = 0;

    public int _countSubstrings_(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }

    /**
     * 马拉车算法，看不懂可以百度下
     *
     * @param S
     * @return
     */
    public int __countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("a"));
    }
}
