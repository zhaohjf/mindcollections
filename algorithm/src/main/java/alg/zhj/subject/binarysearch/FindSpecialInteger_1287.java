package alg.zhj.subject.binarysearch;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by zhaohongjie on 2020/8/22.
 */
public class FindSpecialInteger_1287 {

    private int NOT_FIND_RESULT_NUM = -1;

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int distance = n / 4;
        for (int i = 0; i < n; i += distance) {
            int left = lowerBound(arr, 0, n, arr[i]);
            int right = upperBound(arr, 0, n, arr[i]);
            if (right - left > distance) {
                return arr[i];
            }
        }

        return NOT_FIND_RESULT_NUM;
    }

    int lowerBound(int[] arr, int begin, int end, int target) {
        int low = begin;
        int high = end;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int upperBound(int[] arr, int begin, int end, int target) {

        int low = begin;
        int high = end;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
