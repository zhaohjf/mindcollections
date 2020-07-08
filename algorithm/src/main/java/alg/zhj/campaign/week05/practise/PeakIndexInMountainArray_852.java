package alg.zhj.campaign.week05.practise;

/**
 * Created by zhaohongjie on 2020/7/8.
 */
public class PeakIndexInMountainArray_852 {

    public int peakIndexInMountainArray(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (mid > 0 && mid < A.length && A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid] < A[mid - 1] && mid > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 确保百分百有解才能用吧
     *
     * @param A
     * @return
     */
    public int _peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public int __peakIndexInMountainArray(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(nums[mid]>nums[mid+1]){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        // 这里return什么都可以，因为对于此题来说，在循环体内一定会返回
        return -1;

    }

}
