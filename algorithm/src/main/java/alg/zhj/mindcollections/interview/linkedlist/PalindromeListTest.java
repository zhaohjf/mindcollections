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

    /**
     * 反转右半边节点
     *
     * @param head
     * @return
     */
    public boolean isPalindromeList_2(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;  // slow -> 中部
            fast = fast.next.next;  // fast -> 结尾
        }

        // 中间节点的下一个
        fast = slow.next;
        // 中间节点批向null
        slow.next = null;

        // 临时节点，用来翻转链表
        ListNode node = null;
        while (fast != null) {
            node = fast.next;
            fast.next = slow;
            slow = fast;
            fast = node;
        }

        node = slow; // 最后一个节点
        fast = head; // 第一个节点
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }

        slow = node.next;
        node.next = null;
        while (slow != null) {
            fast = slow.next;
            slow.next = node;
            node = slow;
            slow = fast;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(2, 3, 4, 5, 4, 3, 2);

        PalindromeListTest obj = new PalindromeListTest();
        boolean res = obj.isPalindromeList_2(list);
        System.out.println(res);

        LinkedListUtils.printList(list);
    }
}
