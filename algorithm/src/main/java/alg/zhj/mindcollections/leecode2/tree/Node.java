package alg.zhj.mindcollections.leecode2.tree;

import java.util.List;

/**
 * Created by zhaohongjie on 2019/4/21.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
