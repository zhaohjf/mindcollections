package leetcodecampaign;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        List<List<String>> res = palindrome.partition("aab");
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrace(s.toCharArray(), 0, new ArrayList<String>(), ans);
        return ans;
    }

    private void backtrace(char[] c, int index, List<String> temp, List<List<String>> ans) {
        if (index == c.length) {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = index; i < c.length; i++) {
            if (isPalindrome(c, index, i)) {
                temp.add(new String(c, index, i - index + 1));
                backtrace(c, i + 1, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(char[] s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
