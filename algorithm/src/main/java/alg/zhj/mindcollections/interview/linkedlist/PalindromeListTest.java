package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/19.
 */
public class PalindromeListTest {

    public boolean isPalindromeList(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        /**
         * 利用快慢指针找到中间节点，遍历同时反转前面部分的链表，然后再挨个比对
         *
         */
        ListNode fast = head, slow = head;
        ListNode reverseHead = null, afterReverseHead = null;
        while (fast != null && fast.next != null) {

            reverseHead = slow;
            slow = slow.next;
            fast = fast.next.next;

            reverseHead.next = afterReverseHead;
            afterReverseHead = reverseHead;
        }

        // 如果fast不为null，说明链表有奇数个节点，即有唯一的中间节点，回文判断可以不判断这个中间节点
        if (fast != null) {
            slow = slow.next;
        }

        while (reverseHead != null || slow != null) {
            if (reverseHead.val != slow.val) {
                return false;
            }
            reverseHead = reverseHead.next;
            slow = slow.next;
        }


        return true;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(2, 3, 4, 5, 4, 3, 3);

        PalindromeListTest obj = new PalindromeListTest();
        boolean res = obj.isPalindromeList(list);
        System.out.println(res);
    }
}
