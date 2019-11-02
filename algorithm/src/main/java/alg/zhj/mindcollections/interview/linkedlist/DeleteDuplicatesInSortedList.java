package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/2.
 */
public class DeleteDuplicatesInSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = head;
        while (curr != null) {

            if (pre.val != curr.val) {
                pre.next = curr;
                pre = curr;
            }
            curr = curr.next;
        }

        pre.next = null;

        return head;
    }

    public ListNode deleteDuplicates_2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicatesInSortedList obj = new DeleteDuplicatesInSortedList();

        ListNode list = LinkedListUtils.getLinkedList(1, 1, 2, 3, 3);
        LinkedListUtils.printList(obj.deleteDuplicates(list));
    }
}
