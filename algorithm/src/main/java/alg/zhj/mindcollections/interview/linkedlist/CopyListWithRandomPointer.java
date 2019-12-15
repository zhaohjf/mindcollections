package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/submissions/
 *
 * 解题思路：
 * 1，从左到右遍历节点，为每个一个节点生成一个副本，并将这个副本放在该节点与其下一个节点之间。
 * 2，再从左到右遍历，为每一个副本节点设置random指针；规律：复制节点random指向，原节点random指针指向节点的next节点！
 * 3，拆分
 *
 * Created by zhaohongjie on 2019/12/15.
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        // 在每个节点后，复制生成一个新节点
        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val, curr.next, null);
            curr.next = node;
            curr = node.next;
        }

        // 为复制的新节点初始化random指针
        curr = head;
        Node currCopy = null;
        while (curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }

        // 拆分
        curr = head;
        Node next = null;
        Node deepCopy = head.next;
        while (curr != null) {
            next = curr.next.next;
            currCopy = curr.next;
            curr.next = next;
            currCopy.next = next != null ? next.next : null;
            curr = next;
        }

        return deepCopy;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();

        Node n1 = new Node();
        Node n2 = new Node();

        n1.val = 1;
        n1.next = n2;
        n1.random = n2;

        n2.val = 2;
        n2.next = null;
        n2.random = n2;

        Node node = obj.copyRandomList(n1);
        System.out.print(node);
    }

    public Node copyRandomList_2(Node head) {
        if (head == null)return null;
        Node temp = head;
        Node curr = null;
        while (temp != null) {
            curr = new Node(temp.val,temp.next,null);
            temp.next = curr;
            temp = curr.next;
        }
        temp = head;
        while (temp != null) {
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }
        temp = head.next;
        curr = temp;
        while (head != null) {

            head.next = temp.next;
            head = head.next;
            temp.next = head == null ? null : head.next;
            temp = temp.next;
        }
        return curr;
    }
}
