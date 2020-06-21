package alg.zhj.campaign.week03.practise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [
 ["London","New York"]
 ["New York","Lima"]
 ["Lima","Sao Paulo"]
 ]

 *
 * Created by zhaohongjie on 2020/6/21.
 */
public class DestCity_1436 {

    public String destCity(List<List<String>> paths) {
        Set<String> set= new HashSet<>();
        for (List<String> l: paths) set.add(l.get(1));
        for (List<String> l: paths) set.remove(l.get(0));
        return set.iterator().next();
    }
}
