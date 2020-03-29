package alg.zhj.mindcollections.leecode.segmenttree;

/**
 * 7ms
 *
 * 如果只是区间求和，没有更新操作的话。缓存可以做到极大的速度提升，空间占用O(n)
 *
 * Created by zhaohongjie on 2020/3/29.
 */
public class NumArray_Cache {

    private int[] cache;
    public NumArray_Cache(int[] nums) {

        cache = new int[nums.length];

        if(cache.length>0){
            cache[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                cache[i]=nums[i];
                cache[i] += cache[i-1];
            }
        }

    }

    public int sumRange(int i, int j) {
        if(this.cache.length==0)
            return 0;
        //so sumRange(i,j) is just sumRange(0,j)-sumRange(0,i-1)
        if(i==0){
            return cache[j];
        }else{
            return cache[j] - cache[i-1];
        }
    }
}
