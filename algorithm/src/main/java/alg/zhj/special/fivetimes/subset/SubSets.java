package alg.zhj.special.fivetimes.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一个解法是利用数学归纳的思想：假设我现在知道了规模更小的子问题的结果，如何推导出当前问题的结果呢？

 具体来说就是，现在让你求 [1,2,3] 的子集，如果你知道了 [1,2] 的子集，是否可以推导出 [1,2,3] 的子集呢？先把 [1,2] 的子集写出来瞅瞅：

 [ [],[1],[2],[1,2] ]

 你会发现这样一个规律：

 subset([1,2,3]) - subset([1,2])

 = [3],[1,3],[2,3],[1,2,3]

 而这个结果，就是把 sebset([1,2]) 的结果中每个集合再添加上 3。

 换句话说，如果 A = subset([1,2]) ，那么：

 subset([1,2,3])

 = A + [A[i].add(3) for i = 1..len(A)]

 这就是一个典型的递归结构嘛，[1,2,3] 的子集可以由 [1,2] 追加得出，[1,2] 的子集可以由 [1] 追加得出，
 base case 显然就是当输入集合为空集时，输出子集也就是一个空集。
 *
 * 模板：
 *  result = []
    def backtrack(路径, 选择列表):
        if 满足结束条件:
            result.add(路径)
            return
        for 选择 in 选择列表:
            做选择
            backtrack(路径, 选择列表)
            撤销选择
 *
 * Created by zhaohongjie on 2020/6/26.
 */
public class SubSets {

    /**
     * 递归方式
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        recurse(nums, nums.length - 1, ans);
        return ans;
    }
    private void recurse(int[] nums, int level, List<List<Integer>> ans) {
        if (level < 0) {
            return;
        }
        int n = nums[level];
        recurse(nums, --level, ans);

        int size = ans.size();
        for (int i = 0; i < size; i++) {
            List<Integer> tmp = new ArrayList<>(ans.get(i));
            tmp.add(n);
            ans.add(tmp);
        }
    }

    /**
     * 回溯解法1
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> _subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 遍历整个数组，同上面递归方式类似，只不过是不需要for循环，时间复杂度它们是一样的O(2^n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> _dfs_subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        dfs_2(0, nums.length, nums, new ArrayList<>(), res);

        return res;
    }
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

    /**
     * 不过这个方法有一处效率不好的地方，由于没有回溯操作，所以临时结果再做参数时，需要进行一次深拷贝，防止脏数据；但这样的话，算法的空间复杂度
     * 就升高了，时间复杂度还是O(2^n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets_3(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        dfs_3(nums, new ArrayList<>(), res, 0);

        return res;
    }
    public void dfs_3(int[] nums, List<Integer> subList, List<List<Integer>> res, int index) {

        if (index >= nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        dfs_3(nums, new ArrayList<>(subList), res, index + 1);
        subList.add(nums[index]);
        dfs_3(nums, new ArrayList<>(subList), res, index + 1);
    }

    /**
     * 位运算
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

    /**
     * 线性解决
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

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] a = {1, 2, 3};
        System.out.println(subSets.subsets(a));
    }
}
