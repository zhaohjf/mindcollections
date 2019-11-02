package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/2.
 */
public class LinkedListUtils {

    public static ListNode getLinkedList(int headValue, int... array) {

        ListNode head = new ListNode(headValue);

        ListNode curr = head;
        for (int value : array) {
            ListNode node = new ListNode(value);
            curr.next = node;
            curr = node;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list = getLinkedList(1, 4, 5, 6, 9);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
