package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * Created by zhaohongjie on 2019/11/2.
 */
public class RemoveElement {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;

        ListNode curr = head;
        ListNode pre = virtualHead;

        while (curr != null) {

            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }

            curr = curr.next;
        }

        return virtualHead.next;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();

        ListNode list = LinkedListUtils.getLinkedList(1, 1, 1);
        ListNode listNode = obj.removeElements(list, 1);
        if (listNode == null) {
            System.out.print(true);
        }
    }
}
