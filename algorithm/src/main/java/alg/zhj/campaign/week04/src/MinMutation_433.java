package alg.zhj.campaign.week04.src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by zhaohongjie on 2020/6/30.
 */
public class MinMutation_433 {

    /**
     * 自己写的，不知道是什么，哈哈~~！
     *
     */
    int ans = 0;
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        traceback(start.toCharArray(), end.toCharArray(), set, 0, 0);
        return ans;
    }
    private void traceback(char[] start, char[] end, Set<String> bank, int time, int level) {
        if (String.valueOf(start).equals(String.valueOf(end))) {
            ans = Math.min(ans, time);
            return;
        }

        for (int i = level; i < start.length; i++) {
            char ori = start[i];
            start[i] = end[i];
            if (!bank.contains(String.valueOf(start))) {
                start[i] = ori;
                continue;
            }
            traceback(start, end, bank, time + 1, i + 1);
            start[i] = ori;
        }
    }

    /**
     * DFS
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int _recurse_minMutation(String start, String end, String[] bank) {
        recurse(start, end, bank, 0, new HashSet<String>());
        return count == Integer.MAX_VALUE ? -1 : count;
    }
    int count = Integer.MAX_VALUE;
    private void recurse(String start, String end, String[] bank, int soFar, Set<String> visited) {
        if(start.intern() == end.intern()) {
            count = Math.min(count, soFar);
        }

        for(String e : bank) {
            int diff = 0;
            for(int i = 0; i < e.length(); i++) {
                if(start.charAt(i) != e.charAt(i)) {
                    diff++;
                    if(diff > 1) break;
                }
            }
            if(diff == 1 && !visited.contains(e)) {
                visited.add(e);
                recurse(e, end, bank, soFar+1, visited);
                visited.remove(e);
            }
        }
    }

    /**
     * BFS
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int _minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;

        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);

        char[] charSet = {'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) return level;

                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinMutation_433 obj = new MinMutation_433();
        String[] bank = {"AACCGGTA"};
        System.out.print(obj._minMutation("AACCGGTT", "AACCGGTA", bank));
    }
}
