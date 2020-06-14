package alg.zhj.special.fivetimes.knapsack;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 *
 * Created by zhaohongjie on 2020/4/18.
 */
public class Knapsack01_KPartition {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }

        int target = sum / k;

        Arrays.sort(nums);
        int lastIndex = nums.length - 1;
        if (nums[lastIndex] > target) {
            return false;
        }
        while (lastIndex >= 0 && nums[lastIndex] == target) {
            k--;
            lastIndex--;
        }

        return search(new int[k], lastIndex, nums, target);
    }

    /**
     * 对于 nums 中的每个数字，我们可以将其添加到 k 个子集中的一个，只要该子集的和不会超过目标值。
     * 对于每一个选择，我们都递归地用一个更小的数字进行搜索，以便在nums中考虑。如果我们成功地放置了每个数字，那么我们的搜索就成功了。
     *
     * @param groups
     * @param index
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] groups, int index, int[] nums, int target) {

        if (index < 0) {
            return true;
        }

        int v = nums[index--];
        for (int i = 0; i < groups.length; i++) {

            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, index, nums, target)) {
                    return true;
                }
                groups[i] -= v;
            }

            /**
             * 一个重要的细节是，通过判断 if (groups[i] == 0) break;，我们可以确保每个 group 的所有 0 值都出现在数组 groups 的末尾。
             * 这大大减少了重复的工作——例如，在第一次运行搜索时，我们只进行一次递归调用，而不是 k 次。
             * 还可以通过跳过 group[i] 的重复值来加快速度，但这是不必要的。
             */
            if (groups[i] == 0) {
                break;
            }
        }

        return false;
    }

    /**
     * ==============================================
     */

    public boolean canPartitionKSubsets_2(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (k <= 0 || sum % k != 0) {
            return false;
        }

        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum / k);
    }

    /**
     * 6ms 上面算法是3ms
     *
     * 动态规则这种东西，真的是太难了。解决问题的方式太多了，数学好的真可以写出很高效的代码（多训练）。
     *
     * @param nums               输入数组
     * @param visited            记录数组中元素是否已经被使用过
     * @param start_index        指向输入数组的指针
     * @param k                  目标划分数
     * @param cur_sum            当前累加和
     * @param cur_num            当前累加了多少个值
     * @param target             累加目标值
     * @return
     */
    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target) {
        if (k == 1) {
            return true;
        }
        if (cur_sum == target && cur_num > 0) {
            return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        }
        for (int i = start_index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartition(nums, visited, i + 1, k, cur_sum + nums[i], cur_num++, target)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Knapsack01_KPartition obj = new Knapsack01_KPartition();
        System.out.println(obj.canPartitionKSubsets_2(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
