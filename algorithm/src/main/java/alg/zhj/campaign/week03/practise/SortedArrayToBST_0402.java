package alg.zhj.campaign.week03.practise;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

/**
 * Created by zhaohongjie on 2020/6/21.
 */
public class SortedArrayToBST_0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, left, mid - 1);
            root.right = dfs(nums, mid + 1, right);
            return root;
        }

        return null;
    }

}
