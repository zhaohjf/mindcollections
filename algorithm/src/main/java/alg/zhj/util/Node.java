package alg.zhj.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zhaohongjie on 2020/7/8.
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
        children = Lists.newArrayList();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
