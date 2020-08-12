package alg.zhj.util;

/**
 * Created by zhaohongjie on 2020/8/12.
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

    public static ListNode getCircleLinkedList(int headValue, int... array) {

        ListNode head = new ListNode(headValue);

        ListNode curr = head;
        for (int value : array) {
            ListNode node = new ListNode(value);
            curr.next = node;
            curr = node;
        }

        curr.next = head;

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = getLinkedList(1, 4, 5, 6, 9);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
