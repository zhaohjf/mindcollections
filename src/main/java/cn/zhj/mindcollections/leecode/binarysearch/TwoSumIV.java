package cn.zhj.mindcollections.leecode.binarysearch;

import cn.zhj.mindcollections.leecode.binarytree.search.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 *
 * 区别前一个题目，这个题目是在有序二叉树中查找两个值
 *
 * Created by zhaohongjie on 2019/2/4.
 */
public class TwoSumIV {


    /**
     * 二叉查找树也是一个有序结构
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, k, set);
    }

    /**
     * 有状态的递归，可以更改为递推
     *
     * @param root
     * @param k
     * @param set
     * @return
     */
    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
