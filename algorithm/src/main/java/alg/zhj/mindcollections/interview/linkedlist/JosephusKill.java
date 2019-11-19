package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/17.
 */
public class JosephusKill {

    /**
     * 删除一个节点就要遍历m次，所以复杂度为O(m*n)
     *
     * @param head
     * @param m
     * @return
     */
    public ListNode josephusKill_1(ListNode head, int m) {

        if (head == null || head.next == head || m < 1) {
            return head;
        }

        /**
         * 比如，我们要删除数到3的节点，链表删除一个节点时，必须知道它的前一个节点是什么才行；
         * 因此，我实际要找其实是数到2的节点。
         *
         */
        ListNode curr = head;
        int count = 1;
        while (curr.next != curr) {
            if (count == m - 1) {
                curr.next = curr.next.next;
                curr = curr.next;
                count = 1;
            } else {
                curr = curr.next;
                count++;
            }
        }

        return curr;
    }

    public ListNode josephusKill_2(ListNode head, int m) {

        if (head == null || head.next == head || m < 1) {
            return head;
        }

        // 找到头节点的前一个节点
        ListNode last = head;
        while (last.next != head) {
            last = last.next;
        }

        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }

            head = last.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getCircleLinkedList(1, 4, 5, 6, 9);

        JosephusKill obj = new JosephusKill();
        ListNode node = obj.josephusKill_2(list, 3);
        System.out.print(node.val);
    }
}
