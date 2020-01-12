package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * Created by zhaohongjie on 2020/1/12.
 */
public class PartitionList {

    /**
     * 直觉上比较平铺直述的解法，没有完备的一个抽象逻辑；比较容易出Bug
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition_native(ListNode head, int x) {

        if (head == null) {
            return head;
        }

        ListNode l = new ListNode(0);
        ListNode r = new ListNode(0);
        ListNode lHead = l, rHead = r;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                l.next = cur;
                l = l.next;
            } else {
                r.next = cur;
                r = r.next;
            }
            cur = cur.next;
        }
        // 为这节省空间复用了原有节点，导致残留了原链表的引用关系，所以，这里要清理下
        r.next = null;

        l.next = rHead.next;

        return lHead.next;
    }

    /**
     * 解法2
     *
     * @param args
     */
    // TODO 利用快排算法，将链表转换为数组，再进行划分；问题是无法保证顺序的前后一致

    /**
     * leeCode官方解答
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 4, 3, 2, 5, 2);

        PartitionList obj = new PartitionList();
        LinkedListUtils.printList(obj.partition_native(list, 3));
    }
}
