package alg.zhj.practise.dp;

public class JumpGameI {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public boolean canJump_dp(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        JumpGameI obj = new JumpGameI();
        System.out.println(obj.canJump_dp(new int[]{2, 3, 1, 1, 4}));
    }
}
