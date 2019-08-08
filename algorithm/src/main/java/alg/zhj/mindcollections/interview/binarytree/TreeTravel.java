package alg.zhj.mindcollections.interview.binarytree;

import java.util.Stack;

/**
 * Created by zhaohongjie on 2019/4/14.
 */
public class TreeTravel {

    public void preOrderRecur(Node head) {

        if (head == null) {
            return;
        }

        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void preOrderUnRecur(Node head) {

        System.out.print("pre-order: ");

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

        System.out.println();
    }

    public void inOrderRecur(Node head) {

        if (head == null) {
            return;
        }

        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public void inOrderUnRecur(Node head) {

        System.out.print("in-order: ");

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }

        System.out.println();
    }

    public void postOrderRecur(Node head) {

        if (head == null) {
            return;
        }

        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public void postOrderUnRecur1(Node head) {

        System.out.print("post-order: ");

        if (head == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }

        System.out.println();
    }

    public void postOrderUnRecur2(Node head) {

        System.out.print("post-order: ");

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node pre = head;  // 前继节点
        Node curr = null; // 当前节点

        while (!stack.isEmpty()) {
            curr = stack.peek();
            // 如果当前节点 左孩子 不为空， 且 前一个被处理过的节点 不是 它的 左 或者 右 孩子； 否则，
            if (curr.left != null && pre != curr.left && pre != curr.right) {
                stack.push(curr.left);
            }
            // 如果当前节点 右孩子 不为空， 且 前一个被处理过的节点 不是 它的 右孩子； 否则，
            else if (curr.right != null && pre != curr.right) {
                stack.push(curr.right);
            }
            // 保存栈顶元素，并将其记录到pre指针
            else {
                System.out.print(stack.pop().value + " ");
                pre = curr;
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        TreeTravel obj = new TreeTravel();
        Node head = obj.buildTree();

        obj.preOrderRecur(head);
        System.out.println();
        obj.preOrderUnRecur(head);

        obj.inOrderRecur(head);
        System.out.println();
        obj.inOrderUnRecur(head);

        obj.postOrderRecur(head);
        System.out.println();
        obj.postOrderUnRecur1(head);
        obj.postOrderUnRecur2(head);
    }

    private Node buildTree() {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node five = new Node(5);
        Node six = new Node(6);
        Node eight = new Node(8);
        Node nine = new Node(9);

        Node head = five;
        head.left = two;
        head.right = eight;
        two.left = one;
        two.right = three;
        eight.left = six;
        eight.right = nine;

        return head;
    }
}
