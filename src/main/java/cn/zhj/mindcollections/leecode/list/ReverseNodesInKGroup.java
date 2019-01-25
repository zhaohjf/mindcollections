package cn.zhj.mindcollections.leecode.list;

/**
 * Created by zhaohongjie on 2018/12/24.
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        /**
         * pre节点为一个空节点，将其指向cur节点，也就是head节点。
         *
         */
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, cur = head;
        dummy.next = head;

        int i = 0;
        while (cur != null) {

            /**
             * 分段，按k值大小，将链表分段，在每段内再进行反转
             *
             */
            ++i;
            if (i % k == 0) {
                pre = reverseOneGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }


        return dummy.next;
    }

    /**
     * pre指针（哨兵节点）永远指向局部翻转链表的头节点
     *
     * 难点是局部翻转，翻转后依然要保证是一个完整的链表。
     *
     * @param pre
     * @param next
     * @return
     */
    private ListNode reverseOneGroup(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;

        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }

        return last;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ReverseNodesInKGroup reverse = new ReverseNodesInKGroup();
        ListNode node = reverse.reverseKGroup(one, 2);
        System.out.println(node.val);
    }
}
