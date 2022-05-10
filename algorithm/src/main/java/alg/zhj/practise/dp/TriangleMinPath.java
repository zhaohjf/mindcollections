package alg.zhj.practise.dp;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * https://leetcode.cn/problems/IlPe0q/
 */
public class TriangleMinPath {

    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int value = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, value);
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = Lists.newArrayList(
                Lists.newArrayList(2),
                Lists.newArrayList(3, 4),
                Lists.newArrayList(6, 5, 7),
                Lists.newArrayList(4, 1, 8, 3)
        );

        int ans = minimumTotal(triangle);
        System.out.println(ans);
    }
}
