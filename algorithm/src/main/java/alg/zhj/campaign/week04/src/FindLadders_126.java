package alg.zhj.campaign.week04.src;

import java.util.*;

/**
 * Created by zhaohongjie on 2020/7/1.
 */
public class FindLadders_126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);
        // neighbors for every node
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        // Distance of every node from the start node
        Map<String, Integer> distance = new HashMap<>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, new ArrayList<>(), ans);

        return ans;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors,
                     Map<String, Integer> distance) {
        // init neighbor index
        for (String word : dict) {
            nodeNeighbors.put(word, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                Integer curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    // Check if visited
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (neighbor.equals(end)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (foundEnd) {
                    break;
                }
            }
        }
    }

    // Find all next level nodes.
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        char[] chs = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }
                char old = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    ans.add(String.valueOf(chs));
                }
                chs[i] = old;
            }
        }
        return ans;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors,
                     Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}
