package cn.zhj.mindcollections.leecode.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * Created by zhaohongjie on 2019/2/20.
 */
public class Triangle {

    /**
     * 递归公式：
     * travel(i, j){
     *     travel(i + 1, j);
     *     travel(i + 1, j + 1);
     * }
     *
     * 递归使用深度优先搜索，遍历所有可能的路径，选出最小一条路径出来。这其中会有很多的重复计算，时间复杂度为O(2^n)。
     *
     * 当然也可以通过记录中间状态来减少重复计算，减小时间复杂度
     * ——这就需要将问题转换到递推，使用动态规划，记录局部最优解，最终达到全局最优。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int row = triangle.size();
        int col = triangle.get(triangle.size() - 1).size();
        int[][] resA = new int[row][col];
        for (int i = 0 ; i < col; i++) {
            resA[row - 1][i] = triangle.get(row - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                resA[i][j] = triangle.get(i).get(j) + Math.min(resA[i + 1][j], resA[i + 1][j + 1]);
            }
        }

        return resA[0][0];
    }

    /**
     * 压缩临时空间
     *
     * @param triangle
     * @return
     */
    public int minimumTotal_1(List<List<Integer>> triangle) {

        List<Integer> mini = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                mini.set(j, triangle.get(i).get(j) + Math.min(mini.get(j), mini.get(j + 1)));
            }
        }
        return mini.get(0);
    }

    public static void main(String[] args) {

        List<List<Integer>> params = new ArrayList<>();

        List<Integer> param1 = new ArrayList<>();
        param1.add(2);
        List<Integer> param2 = new ArrayList<>();
        param2.add(3);
        param2.add(4);
        List<Integer> param3 = new ArrayList<>();
        param3.add(6);
        param3.add(5);
        param3.add(7);
        List<Integer> param4 = new ArrayList<>();
        param4.add(4);
        param4.add(1);
        param4.add(8);
        param4.add(3);

        params.add(param1);
        params.add(param2);
        params.add(param3);
        params.add(param4);

        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal_1(params));
    }
}
