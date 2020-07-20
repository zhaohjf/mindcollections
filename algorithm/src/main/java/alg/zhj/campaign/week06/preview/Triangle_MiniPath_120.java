package alg.zhj.campaign.week06.preview;

import java.util.List;

/**
 * Created by zhaohongjie on 2020/7/13.
 */
public class Triangle_MiniPath_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> mini = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                mini.set(j, triangle.get(i).get(j) + Math.min(mini.get(j), mini.get(j + 1)));
            }
        }
        return mini.get(0);
    }
}
