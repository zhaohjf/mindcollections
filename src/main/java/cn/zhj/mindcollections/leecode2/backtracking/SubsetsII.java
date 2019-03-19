package cn.zhj.mindcollections.leecode2.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * <p>
 * Created by zhaohongjie on 2019/3/8.
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, new ArrayList<>(), nums, new boolean[nums.length], 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] exists, int start) {

        list.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {

            /**
             * 当i被使用过为true时，当然不可以再次使用
             *
             * 当i为false时，如果它的前一元素同它相等且这个元素没有被使用过，continue
             *            ，如果它的前一元素同它相等且这个元素已经被使用过，可以使用这个元素
             *
             * 1， 2，    2
             *   true  false
             * 这种情况下，第二个2是可用的
             *
             * 1，  2，    2
             *   false  false
             * 都为false情况下，第二个2不可用，因为这个就会有重复
             *
             * 也就是说，对于排序后数组中值相等的元素，只有前一个的被使用了，后面那个才可以被使用。
             */
            if (exists[i] || (i > 0 && nums[i] == nums[i - 1] && exists[i - 1] == false)) {
                continue;
            }

            tempList.add(nums[i]);
            exists[i] = true;
            dfs(list, tempList, nums, exists, i + 1);
            tempList.remove(tempList.size() - 1);
            exists[i] = false;
        }
    }

    // ======================================================================================================================================

    public List<List<Integer>> subsetsWithDup_1(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        Arrays.sort(nums);

        dfs_1(nums, 0, new ArrayList<>(), res);

        return res;
    }

    /**
     * 有重复元素，记得先排序
     * <p>
     * 如果前一个元素同自己相同，则放弃， continue;
     *
     * @param nums
     * @param start
     * @param subres
     * @param res
     */
    private void dfs_1(int[] nums, int start, List<Integer> subres, List<List<Integer>> res) {
        res.add(new ArrayList<>(subres));

        for (int i = start; i < nums.length; i++) {

            //遇到重复元素，并且自己不是第一个就不选了
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subres.add(nums[i]);
            dfs_1(nums, i + 1, subres, res);
            subres.remove(subres.size() - 1);
        }
    }

    // ======================================================================================================================================

    public List<List<Integer>> subsetsWithDup_2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        Arrays.sort(nums);

        dfs_2(nums, new ArrayList<Integer>(), res, 0);

        return res;
    }

    /**
     * DFS, leetcode有很多类似的重复变形的题目, 和不包含重复元素的区别是在遍历到某个值时, 可以分为拿和不拿.
     * <p>
     * 如果拿的话就按照正常往下一层搜索, 如果不拿当前值的话, 那么也要跳过接下来和当前值相等的元素.
     *
     * @param nums
     * @param subList
     * @param res
     * @param k
     */
    private void dfs_2(int[] nums, List<Integer> subList, List<List<Integer>> res, int k) {

        if (k >= nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        int x = k;
        while (k + 1 < nums.length && nums[k] == nums[k + 1]) {
            k++;
        }

        dfs_2(nums, new ArrayList<>(subList), res, k + 1);
        subList.add(nums[k]);
        dfs_2(nums, new ArrayList<>(subList), res, x + 1);
    }

    // ======================================================================================================================================

    public List<List<Integer>> subsetsWithDup_3(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        Arrays.sort(nums);

        dfs_3(nums, new ArrayList<Integer>(), res, 0);

        return res;
    }

    /**
     * 是上面方法2在空间复杂度上的改进
     *
     * @param nums
     * @param subList
     * @param res
     * @param index
     */
    private void dfs_3(int[] nums, List<Integer> subList, List<List<Integer>> res, int index) {

        if (index >= nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        int x = index;
        while (x + 1 < nums.length && nums[x] == nums[x + 1]) {
            x++;
        }

        dfs_3(nums, subList, res, x + 1);
        subList.add(nums[index]);
        dfs_3(nums, subList, res, index + 1);
        subList.remove(subList.size() - 1);
    }

    // ======================================================================================================================================

    /**
     * 逻辑：
     * 初始情况下，结果数组中只有为空[]的一个子集；
     * 然后，遍历参数数组；对于每一个元素，遍历结果数组中的每一个list，进行深拷贝，将当前元素加入到深拷贝后的list中，然后将这个list添加到结果数组中。
     *
     * 遍历过程：
     * []->[[],[1]]
     * [[],[1]]->[[],[1],[2],[1,2],[2,2],[1,2,2],[2,2,2],[1,2,2,2]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup_Liner(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            int count = 0;
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            while (i < nums.length && nums[i] == num) {
                i++;
                count++;
            }
            for (List<Integer> list : res) {//每次在原来的基础上增加即可
                List<Integer> now = new ArrayList(list);
                for (int j = 0; j < count; j++) {
                    now.add(num);
                    tmp.add(new ArrayList(now));
                }

            }
            res.addAll(tmp);

        }

        return res;
    }

    // ======================================================================================================================================

    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        List<List<Integer>> lists = subsets.subsetsWithDup_Liner(new int[]{1, 2, 2, 2});

        lists.forEach(list -> {
            list.forEach(c -> System.out.print(c + ","));
            System.out.println();
        });
    }

}
