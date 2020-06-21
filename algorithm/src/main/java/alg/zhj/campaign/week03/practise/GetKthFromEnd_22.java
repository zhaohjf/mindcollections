package alg.zhj.campaign.week03.practise;

import alg.zhj.mindcollections.interview.linkedlist.ListNode;

/**
 * Created by zhaohongjie on 2020/6/21.
 */
public class GetKthFromEnd_22 {
    /**
     *
     * @param node 某个节点
     * @return 节点的长度
     */
    public int getLength(ListNode node){
        if(node == null){
            return 0;
        }
        return getLength(node.next)+1;
    }
    public ListNode getKthFromEnd(ListNode head, int k) {

        if(getLength(head) == k){
            return head;
        }
        return getKthFromEnd(head.next, k);

    }
}
