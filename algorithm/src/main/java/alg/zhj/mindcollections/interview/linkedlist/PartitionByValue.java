package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/25.
 */
public class PartitionByValue {

    /**
     * 转换成数组，利用快排的partition算法
     *
     * @param head
     * @param pivot
     * @return
     */
    public ListNode listPartition(ListNode head, int pivot) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        ListNode[] nodeArr = new ListNode[i];
        i = 0;
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartition(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }

        nodeArr[i - 1].next = null;

        return nodeArr[0];
    }

    private void arrPartition(ListNode[] nodeArr, int pivot) {

        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].val == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    private void swap(ListNode[] nodeArr, int a, int b) {
        ListNode temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(9, 0, 4, 5, 1);

        PartitionByValue obj = new PartitionByValue();
        LinkedListUtils.printList(obj.listPartition(list, 3));
    }
}
