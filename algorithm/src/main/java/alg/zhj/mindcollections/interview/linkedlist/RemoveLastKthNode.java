package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/2.
 */
public class RemoveLastKthNode {

    /**
     * 遍历两次，第一次递减lastKth；
     *
     * 大于0，返回原链表，因为要删除的节点不存在；等于0，删除的节点就是头节点；
     *
     * 小于0，开始第二次遍历，这时lastKth开始+1递增，直到lastKth == 0 时，这时指向的节点就是要删除节点的一个节点。
     *
     * @param node
     * @param lastKth
     * @return
     */
    public ListNode removeLastKthNode(ListNode node, int lastKth) {

        if (node == null || lastKth < 1) {
            return node;
        }

        ListNode curr = node;
        while (curr != null) {
            lastKth--;
            curr = curr.next;
        }

        if (lastKth == 0) {
            return node.next;
        }

        if (lastKth > 0) {
            return node;
        }

        curr = node;
        while (++lastKth != 0) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return node;
    }

    public static void main(String[] args) {

        RemoveLastKthNode obj = new RemoveLastKthNode();
        ListNode list = LinkedListUtils.getLinkedList(2, 3, 4, 5, 6, 9, 12);

        ListNode listNode = obj.removeLastKthNode(list, 7);
        LinkedListUtils.printList(listNode);
    }
}
