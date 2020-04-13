package alg.zhj.mindcollections.leecode.segmenttree;

/**
 * 这应该是个树状数组的解法，等了解后再过来看。
 *
 * Created by zhaohongjie on 2020/3/29.
 */
public class NumArray_2 {

    int[] c;
    int[] nums;
    int n;

    /**
     * 树状数组为什么要从 +1 开始
     *
     * @param nums
     */
    public NumArray_2(int[] nums) {
        n = nums.length;
        this.nums = nums;
        c = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public void add(int i, int val) {
        while (i <= n) {
            c[i] += val;
            i += lowBit(i);
        }
    }

    public int sumRange(int i, int j) {
        if (i <= 0) {
            return sum(j + 1);
        }
        return sum(j + 1) - sum(i);
    }

    public int sum(int i) {
        int ret = 0;
        while (i > 0) {
            ret += c[i];
            i -= lowBit(i);
        }
        return ret;
    }

    private int lowBit(int x) {
        return x & (-x);
    }
}
