package cn.zhj.mindcollections.leecode2.dfs;

import cn.zhj.mindcollections.leecode2.base.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * Created by zhaohongjie on 2019/3/6.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    /**
     * 递归分治思想
     *
     * 找到数组中位数以后，将问题分为两个子问题，分别在左右两个子数组中，构建一个高度平衡二叉树，以此类推
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private TreeNode dfs(int[] nums, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[m]);
            root.left = dfs(nums, l, m - 1);
            root.right = dfs(nums, m + 1, r);
            return root;
        }
        return null;
    }

    
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree obj = new ConvertSortedArrayToBinarySearchTree();
        TreeNode treeNode = obj.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

}
