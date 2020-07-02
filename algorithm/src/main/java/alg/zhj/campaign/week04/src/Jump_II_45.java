package alg.zhj.campaign.week04.src;

/**
 * Created by zhaohongjie on 2020/7/2.
 */
public class Jump_II_45 {

    /**
     * 贪心：在可跳范围内选择最远的
     *
     * 都是bug,没做出来
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int i = 0, ans = 0;
        while (i < n -1) {
            ans++;
            if (nums[i] == 0) {
                continue;
            }
            if (i + nums[i] >= n - 1) {
                break;
            }
            int tmp = 0, index = 0;
            for (int k = 1; k <= nums[i] && (i + k) < nums.length; k++) {
                if (nums[i + k] >= tmp) {
                    tmp = nums[i + k];
                    index = i + k;
                }
            }
            i = index;
        }
        return ans;
    }


    public int _jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int __jump(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Jump_II_45 obj = new Jump_II_45();
        System.out.print(obj._jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
    }
}
