package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/12.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode next = head;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 2, 3, 4, 5, 6);

        ReverseList obj = new ReverseList();
        LinkedListUtils.printList(obj.reverseList(list));
    }
}
