package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/10.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // 声明快慢指针
        ListNode fast = head, slow = head;
        ListNode slowReverseHead = head, afterSlowReverseHead = null;

        while (fast != null && fast.next != null) {

            slowReverseHead = slow;
            slow = slow.next;
            fast = fast.next.next;

            slowReverseHead.next = afterSlowReverseHead;
            afterSlowReverseHead = slowReverseHead;
        }

        // 如果fast != null -> 链表节点数为奇数；
        if (fast != null) {
            slow = slow.next;
        }

        while (slowReverseHead != null && slow != null) {
            if (slowReverseHead.val != slow.val) {
                return false;
            }

            slowReverseHead = slowReverseHead.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromeLinkedList obj = new PalindromeLinkedList();
        ListNode head = LinkedListUtils.getLinkedList(2, 3, 2, 2, 3, 2);
        boolean palindrome = obj.isPalindrome(head);
        System.out.print(palindrome);
    }

}
