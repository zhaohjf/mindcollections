package alg.zhj.mindcollections.interview.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 * Created by zhaohongjie on 2020/5/27.
 */
public class SubarraysDivByK_974 {

    public int subarraysDivByK(int[] A, int K) {

        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);

        int sum = 0;
        for (int elem : A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
        }

        record.entrySet().forEach(System.out::println);

        int ans = 0;
        /**
         * 排列组合，前缀和，同余mod K，相减为0，可以被整除
         *
         * 排列组合
         *
         */
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraysDivByK_974 obj = new SubarraysDivByK_974();
        System.out.print(obj.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
