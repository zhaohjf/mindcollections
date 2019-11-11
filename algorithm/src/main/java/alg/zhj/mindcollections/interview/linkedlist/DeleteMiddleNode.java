package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/11.
 */
public class DeleteMiddleNode {

    public ListNode removeMiddleNode(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);

        return head;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 2, 3, 4, 5,6);

        DeleteMiddleNode obj = new DeleteMiddleNode();
        obj.removeMiddleNode(list);
    }
}
