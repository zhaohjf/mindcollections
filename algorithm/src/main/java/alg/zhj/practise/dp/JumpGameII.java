package alg.zhj.practise.dp;

public class JumpGameII {

    public int jump(int[] nums) {
        int step = 0, end = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                step++;
                end = max;
            }
        }

        return step;
    }
}
