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
        if (root == null) {
            return;
        }
        path += Integer.toString(root.val);
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        dfs(root.left, ans, path + "->");
        dfs(root.right, ans, path  + "->");
    }

    public List<String> binaryTreePaths_(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
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
