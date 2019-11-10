package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/submissions/
 *
 * Created by zhaohongjie on 2019/11/10.
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 2, 3, 4, 5, 6);

        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
        ListNode listNode = obj.middleNode(list);
        System.out.print(listNode.val);
    }
}
