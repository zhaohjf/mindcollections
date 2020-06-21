package alg.zhj.campaign.week02.practise;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/20.
 */
public class SmallerNumbersThanCurrent_1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] res = new int[nums.length];

        /**
         * 数组做索引结构
         * 1，索引是有序的
         * 2，元素数量有限时，O(1)随机读取
         *
         * 这里题目限制了是100以内的数字
         */
        int[] buc = new int[101];

        // 初始化
        for (int num : nums) {
            buc[num]++;
        }
        //dp思想确认小于等于当前数字的个数
        for(int i = 1; i < buc.length; i++) {
            buc[i] += buc[i-1];
        }

        for(int i = 0; i < nums.length; i++) {
            res[i] = nums[i] == 0 ? 0 : buc[nums[i]-1];
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> ans = Lists.newArrayList();

        int[] ts = ans.stream().mapToInt(i->i).toArray();
    }
}
