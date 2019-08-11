package cn.zhj.tree;

/**
 * Created by zhaohongjie on 2019/8/11.
 */
public class BinaryTree {

    Node root;

    public static void main(String[] args) {
        System.out.print("hello world");
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
