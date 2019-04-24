package alg.zhj.mindcollections.leecode.binarytree.travel;


import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

import java.util.*;

/**
 * Created by zhaohongjie on 2019/1/28.
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * 使用栈数据结构会增加时间复杂度（4ms）
     *
     * 简单的方法，对得出list倒置下就可以，时间能控制在2ms
     *
     * 利用栈，将前一个算法得出的结果依次入栈，再重新读出即可。
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> bottomStack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level_node = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level_node.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            bottomStack.push(level_node);
        }

        while (!bottomStack.isEmpty()) {
            result.add(bottomStack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode n_3 = new TreeNode(3);
        TreeNode n_9 = new TreeNode(9);
        TreeNode n_20 = new TreeNode(20);
        TreeNode n_15 = new TreeNode(15);
        TreeNode n_7 = new TreeNode(7);

        n_3.left = n_9;
        n_3.right = n_20;

        n_20.left = n_15;
        n_20.right = n_7;

        List<List<Integer>> lists = levelOrderBottom(n_3);
        lists.stream().forEach(list -> {
            list.forEach(c -> System.out.print(c + ", "));
            System.out.println();
        });
    }
}
