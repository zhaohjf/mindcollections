package alg.zhj.practise.tree;

import alg.zhj.util.TreeNode;

/**
 * https://leetcode.cn/problems/w6cpku/
 */
public class BSTSumGtSpecifyNodeVal {

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    int sum = 0;
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

    /**=======================================================================================================================*/

    /**
     * 一种偏门的二叉树遍历方式，有时间可以看下
     *
     * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现中序遍历。这种方法由 J. H. Morris 在 1979 年的论文
     * 「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
     *
     * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其反序中序遍历规则总结如下：
     *
     * 1，如果当前节点的右子节点为空，处理当前节点，并遍历当前节点的左子节点；
     *
     * 2，如果当前节点的右子节点不为空，找到当前节点右子树的最左节点（该节点为当前节点中序遍历的前驱节点）；
     *
     *      如果最左节点的左指针为空，将最左节点的左指针指向当前节点，遍历当前节点的右子节点；
     *
     *      如果最左节点的左指针不为空，将最左节点的左指针重新置为空（恢复树的原状），处理当前节点，并将当前节点置为其左节点；
     *
     * 3，重复步骤 1 和步骤 2，直到遍历结束。
     *
     * 这样我们利用 Morris 遍历的方法，反序中序遍历该二叉搜索树，即可实现线性时间与常数空间的遍历。
     *
     * @param root
     * @return
     */
    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}
