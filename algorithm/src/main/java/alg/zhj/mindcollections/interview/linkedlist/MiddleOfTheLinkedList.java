package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/submissions/
 *
 * Created by zhaohongjie on 2019/11/10.
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode slow = head;
        // 快指针多走一步，这个慢指针会正好是要删除节点的前一个节点
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 2, 3, 4, 5, 6);

        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
        ListNode listNode = obj.middleNode(list);
        LinkedListUtils.printList(listNode);
    }
}
