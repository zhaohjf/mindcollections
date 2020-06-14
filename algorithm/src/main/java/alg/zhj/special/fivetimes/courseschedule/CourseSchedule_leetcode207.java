package alg.zhj.special.fivetimes.courseschedule;

/**
 * Created by zhaohongjie on 2020/5/17.
 */
public class CourseSchedule_leetcode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] graph = new int[numCourses][numCourses];
        for (int[] item : prerequisites) {
            graph[item[0]][item[1]] = 1;
        }

        int[] v = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (v[i] == 2) continue;
            if (dfs(graph, v, i)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] v, int curr) {

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
            if (dfs(graph, v, i)) return true;
        }
        v[curr] = 2;

        return false;
    }

    public static void main(String[] args) {
        int[][] pre = {{1, 0}};
        CourseSchedule_leetcode207 ob = new CourseSchedule_leetcode207();
        System.out.print(ob.canFinish(2, pre));
    }
}
