package alg.zhj.practise.presum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfSameElementOfArray {

    /**
     *
     * @param arr
     * @return
     */
    public long[] getDistances(int[] arr) {
        if (arr == null) {
            return new long[]{};
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        long[] ans = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            int sum = 0;
            for (int pos : list) {
                sum += Math.abs(i - pos);
            }
            ans[i] = sum;
        }

        return ans;
    }

    /**
     * 前、后缀和表示该位置与前面（后面）所有位置的差绝对值之和，
     * 所以该位置所有差之和就为:left[i] + right[i]left[i]+right[i].
     *
     * 假设一个数对应的下标为:a,b,c,d，可以发现其前缀和计算规则如下：
     * left[0] = 0left[0]=0
     * left[i] = left[i - 1] + i * (arr[i] - arr[i - 1])left[i]=left[i−1]+i∗(arr[i]−arr[i−1])
     *
     * 公式推导过程如下：
     * left[0] = 0,left[0]=0,
     * left[1] = b - a = left[0] + 1 * (b - a),left[1]=b−a=left[0]+1∗(b−a),
     * left[2] = c - b + c - a = 2c - b - a, 而left[1]+2*(c - b) = b - a + 2c - 2b = 2c - b - a = left[2],left[2]=c−b+c−a=2c−b−a,而left[1]+2∗(c−b)=b−a+2c−2b=2c−b−a=left[2],
     * left[3] = d - c + d - b + d - a = 3d - c - b - a,left[3]=d−c+d−b+d−a=3d−c−b−a,
     * 而left[2]+3*(d - c) = 2c - b - a + 3d - 3c = 3d - c - b - a = left[3]而left[2]+3∗(d−c)=2c−b−a+3d−3c=3d−c−b−a=left[3]
     *
     * 后缀和类似，
     * right[n - 1] = 0right[n−1]=0
     * right[i] = right[i + 1] + (n - i - 1) * (arr[i + 1] - arr[i])right[i]=right[i+1]+(n−i−1)∗(arr[i+1]−arr[i])
     * 以下标2,5,6,10,13为例，计算过程如下：
     *
     * 作者：merickbao-2
     * 链接：https://leetcode.cn/problems/intervals-between-identical-elements/solution/java-qian-zhui-hou-zhui-he-by-merickbao-mtcpy/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param arr
     * @return
     */
    public long[] getDistances_2(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        // 记录值及其所有下标
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> now = map.getOrDefault(arr[i], new ArrayList<>());
            now.add(i);
            map.put(arr[i], now);
        }
        for (Map.Entry<Integer, List<Integer>> en : map.entrySet()) {
            List<Integer> now = en.getValue();
            int len = now.size();
            // 计算前缀、后缀和
            long[] left = new long[len], right = new long[len];
            for (int i = 1, j = len - 2; i < len; i++, j--) {
                left[i] = left[i - 1] + i * (now.get(i) - now.get(i - 1));
                right[j] = right[j + 1] + (len - j - 1) * (now.get(j + 1) - now.get(j));
            }
            // 记录答案
            for (int i = 0; i < len; i++) {
                ans[now.get(i)] = left[i] + right[i];
            }
        }
        return ans;

    }
}
