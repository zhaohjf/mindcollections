package alg.zhj.special.fivetimes.courseschedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/5/17.
 */
public class CourseSchedule_leetcode210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[][] graph = new int[numCourses][numCourses];
        for (int[] item : prerequisites) {
            graph[item[0]][item[1]] = 1;
        }

        int[] v = new int[numCourses];
        List<Integer> ans =new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (v[i] == 2) continue;
            if (dfs(graph, v, i, ans)) return new int[0];
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    private boolean dfs(int[][] graph, int[] v, int curr, List<Integer> ans) {

        // 有环
        if (v[curr] == 1) {
            return true;
        }
        // 已经访问过
        if (v[curr] == 2) {
            return false;
        }

        v[curr] = 1;
        for (int i = 0; i < graph[curr].length; i++) {
            if (graph[curr][i] == 0) {
                continue;
            }
            if (v[i] == 2) {
                continue;
            }
            if (dfs(graph, v, i, ans)) return true;
        }
        v[curr] = 2;
        ans.add(curr);

        return false;
    }

    public static void main(String[] args) {
        int[][] pre = {{1, 0}};
        CourseSchedule_leetcode210 ob = new CourseSchedule_leetcode210();
        int[] order = ob.findOrder(2, pre);
        Arrays.stream(order).forEach(x -> System.out.print(x + ", "));
    }
}
