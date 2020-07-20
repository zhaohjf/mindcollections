package alg.zhj.campaign.week06.practise;

import alg.zhj.util.Node;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2020/7/8.
 */
public class MaxDepth_N_559 {

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                for (Node n : node.children) {
                    queue.offer(n);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.children = Lists.newArrayList(three, two, four);
        three.children = Lists.newArrayList(five, six);

        System.out.println(maxDepth(one));

    }
}
