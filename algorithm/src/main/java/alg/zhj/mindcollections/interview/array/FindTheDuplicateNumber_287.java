package alg.zhj.mindcollections.interview.array;

/**
 * Created by zhaohongjie on 2020/5/26.
 */
public class FindTheDuplicateNumber_287 {

    /**
     * 修改了原数组
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        for(int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            if (nums[temp] > 0){
                nums[temp] *= -1;
            } else {
                return temp;
            }
        }

        return -1;
    }

    /**
     * 问题转化为求一个的环链表的环开始节点
     *
     * 数组下标为值，数据值为next指针
     *
     * @param nums
     * @return
     */
    public int findDuplicate_awesome(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);

        fast = nums[0];
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
