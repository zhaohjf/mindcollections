package leetcodecampaign;

import java.util.Arrays;

public class Test {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sc = new int[26];
        int[] tc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sc[s.charAt(i) - 'a']++;
            tc[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }
        return true;
    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                ans = nums[i];
            } else if (ans != nums[i]) {
                count--;
            } else {
                count++;
            }
        }
        return ans;
    }

    public void rotate(int[] nums, int k) {
        revert(nums, 0, nums.length - 1);
        int kk = k % nums.length;
        revert(nums, 0, k - 1);
        revert(nums, k, nums.length - 1);
    }

    private void revert(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = nums[0]; R[n - 1] = nums[n - 1];
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i];
        }

        int[] ans = new int[n];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = L[i - 1] * R[i + 1];
        }
        ans[0] = R[1];
        ans[n - 1] = L[n - 2];

        return ans;
    }
    public static void main(String[] args) {
        Test obj = new Test();
        int[] ans = obj.productExceptSelf(new int[]{1, 2, 3, 4});
        Arrays.stream(ans).forEach(x -> System.out.println(x));

    }
}
