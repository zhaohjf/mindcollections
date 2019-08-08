package alg.zhj.mindcollections.leecode.bit;

/**
 * https://leetcode-cn.com/problems/total-hamming-distance/comments/
 * <p>
 * Created by zhaohongjie on 2019/2/14.
 */
public class TotalHammingDistance {

    /**
     * int 类型最长为32位，因此，最外层循环会遍历32次，当然，如果所有元素都计算完成，可以提前跳出循环。
     *
     * 内层循环遍历数组中的每一个元素：
     * 1，统计出最后一位为1的元素个数，根据数组的长度，也可以知道最后一们为0的元素个数；
     * 那么，在这一位上的汉明距离就是最后一位为1的元素个数 乘以 最后一位为0的元素的个数。
     *
     * 2，然后将所有元素都向右移一位（算术右移）。
     *
     * 执行用时: 23 ms
     * 内存消耗: 28.6 MB
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int oneCount = 0;
            int temp = 0;
            for (int j = 0; j < len; j++) {
                oneCount += nums[j] & 1;
                nums[j] >>= 1;
                temp += nums[j] == 0 ? 1 : 0;
            }
            res += oneCount * (len - oneCount);
            if (temp == len) break;
        }
        return res;
    }

    /**
     * 执行用时: 27 ms
     * 内存消耗: 28.1 MB,
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance_2(int[] nums) {

        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int i = 0; i < n; i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }

    public static void main(String[] args) {
        TotalHammingDistance obj = new TotalHammingDistance();
        System.out.println(obj.totalHammingDistance_2(new int[]{4, 14, 2}));
    }
}
