package alg.zhj.mindcollections.leecode.list;

/**
 * Created by zhaohongjie on 2018/12/20.
 */
public class ReverseList {

    /**
     * 反转链表
     *
     * 需要两个指针：1）指向前继节点（哨兵节点）；2）指向当前节点
     *
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    /**
     * 20200322
     * 还不错重写这个算法没有出错
     *
     * @param head
     * @return
     */
    public static ListNode reverse_20200322(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
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

        ListNode node = reverse_20200322(one);
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
}

