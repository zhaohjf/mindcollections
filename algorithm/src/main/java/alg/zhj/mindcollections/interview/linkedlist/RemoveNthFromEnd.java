package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *
 * Created by zhaohongjie on 2019/5/15.
 */
public class RemoveNthFromEnd {

    /**
     * 1，遍历链表，同时减 1 方式来递减 n
     * 2，遍历结束后
     *    如果 n 大于 0 —— 说明链表长度小于n，返回head即可
     *    如果 n 等于 0 —— 那么倒数每n个结点就是头节点
     *    如果 n 小于 0 —— 从头遍历，加 1 递增 n，当 n == 0 时，该节点就是要删除节点的前一个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n < 1) {
            return head;
        }

        ListNode cur = head;
        while (cur != null) {
            n--;
            cur = cur.next;
        }

        if (n == 0) {
            head = head.next;
        } else if (n < 0) {
            cur = head;
            while (++n != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        return head;
    }
}
