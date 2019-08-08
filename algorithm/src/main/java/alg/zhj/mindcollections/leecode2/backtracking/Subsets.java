package alg.zhj.mindcollections.leecode2.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * <p>
 * Created by zhaohongjie on 2019/3/8.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);

        return list;
    }

    /**
     * 数组大小为n，每一位上都会有出现、或不出现两种状态；递归解法见下面逻辑
     *
     * @param list
     * @param tempList
     * @param nums
     * @param start
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    // ============================================================================================================================================

    public List<List<Integer>> subsets_2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        dfs_2(0, nums.length, nums, new ArrayList<>(), res);

        return res;
    }

    /**
     * 不需要循环的递归
     *
     * 逻辑：遍历整个数组，同上面递归方式类似，只不过是不需要for循环，时间复杂度它们是一样的O(2^n)
     *
     * @param pos
     * @param len
     * @param nums
     * @param tmp
     * @param ans
     */
    public void dfs_2(int pos, int len, int[] nums, List<Integer> tmp, List<List<Integer>> ans) {

        if (pos == len) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[pos]);
        dfs_2(pos + 1, len, nums, tmp, ans);
        tmp.remove(tmp.size() - 1);
        dfs_2(pos + 1, len, nums, tmp, ans);
    }

    // ============================================================================================================================================

    public List<List<Integer>> subsets_3(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        dfs_3(nums, new ArrayList<>(), res, 0);

        return res;
    }

    /**
     * 逻辑同上面方法2类似，只不过是顺序不同，
     *
     * 数组中的每一个元素都有两种状态，0，不存在；1，存在。上面方法2是先递归存在的情况，然后再递归不存在的情况。
     *
     * 在这里，情况是相反的~！
     *
     * 不过这个方法有一处效率不好的地方，由于没有回溯操作，所以临时结果再做参数时，需要进行一次深拷贝，防止脏数据；但这样的话，算法的空间复杂度
     * 就升高了，时间复杂度还是O(2^n)。
     *
     * @param nums
     * @param subList
     * @param res
     * @param index
     */
    public void dfs_3(int[] nums, List<Integer> subList, List<List<Integer>> res, int index) {

        if (index >= nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        dfs_3(nums, new ArrayList<>(subList), res, index + 1);
        subList.add(nums[index]);
        dfs_3(nums, new ArrayList<>(subList), res, index + 1);
    }

    // ============================================================================================================================================

    /**
     * 利用位运算
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets_bit(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        int n = nums.length;
        /**
         * 求子集过程中，每个数组元素都有存在和不存在两种状态，所以，子集总数为2的n次方
         *
         * 利用 [0, 2^n) 对应的二进制数，二进制数是连续的，
         * 对于这个区间内的每一个二进制数（长度为n，同数组大小一致）。如果对应位为1，表示子集中存在这个元素；否则，就不存在。
         *
         */
        int allSubSetNum = 1 << n; // 2 的 n 次方

        for (int i = 0; i < allSubSetNum; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 判断j位是0还是1
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }

        return res;
    }

    // ============================================================================================================================================

    /**
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets_Liner(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        res.add(new ArrayList<>());
        for (int i = 0; i<nums.length;i++) {
            List<List<Integer>> tmpContainer = new ArrayList<>();
            for (List sub : res) {
                ArrayList tmp = new ArrayList<>(sub);
                tmp.add(nums[i]);
                tmpContainer.add(tmp);
            }
            res.addAll(tmpContainer);
        }

        return res;
    }

    // ============================================================================================================================================

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> lists = subsets.subsets_Liner(new int[]{1,2,3});

        lists.forEach(list -> {
            list.forEach(c -> System.out.print(c + ","));
            System.out.println();
        });
    }
}
