package alg.zhj.campaign.week08.practise;

import alg.zhj.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/8/7.
 */
public class BinaryTreePaths_257 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, ans, "");
        return ans;
    }

    private static void dfs(TreeNode root, List<String> ans, String path) {
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        dfs(root.left, ans, path + "->" + root.val);
        dfs(root.right, ans, path  + "->" + root.val);
    }

    public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
                paths.add(path);  // 把路径加入到答案中
            else {
                path += "->";  // 当前节点不是叶子节点，继续递归遍历
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

    public List<String> _binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }

    public List<String> __binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null)
            return paths;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        TreeNode n_3 = new TreeNode(1);
        TreeNode n_9 = new TreeNode(2);
        TreeNode n_20 = new TreeNode(3);
        TreeNode n_15 = new TreeNode(15);
        TreeNode n_7 = new TreeNode(5);

        n_3.left = n_9;
        n_3.right = n_20;
        n_9.right = n_7;

        List<String> stringList = binaryTreePaths(n_3);
        System.out.println(stringList);
    }
}
