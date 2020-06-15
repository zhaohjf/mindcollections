package alg.zhj.campaign.week02.src;

import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/16.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
