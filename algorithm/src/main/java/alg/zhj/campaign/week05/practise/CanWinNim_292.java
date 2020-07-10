package alg.zhj.campaign.week05.practise;

import com.google.common.collect.Maps;
import edu.princeton.cs.algs4.In;

import java.util.Map;

/**
 * Created by zhaohongjie on 2020/7/9.
 */
public class CanWinNim_292 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
        // return (n & 3) > 0;
    }

    public boolean _canWinNim(int n) {
        if (n <= 0) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = Maps.newConcurrentMap();
        map.values();
    }
}
