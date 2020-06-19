package alg.zhj.campaign.week02.practise;

/**
 * Created by zhaohongjie on 2020/6/19.
 */
public class NumberOfStep_1342 {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num = num >>> 1; // 由于确保num>0,所以使用无符号右移，提高效率
            } else {
                num--;
            }
            count++;
        }

        return count;
    }
}
