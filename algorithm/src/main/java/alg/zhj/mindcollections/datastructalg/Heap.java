package alg.zhj.mindcollections.datastructalg;

/**
 * Created by zhaohongjie on 2020/4/19.
 */
public class Heap {

    private int[] a; // 数组 从下标1开始存储数据
    private int n;   // 堆可以存储的最大元素个数
    private int size;// 堆中已经存在元素大小

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        size = 0;
    }

    public void insert(int data) {

        if (size >= n) {
            throw new IllegalArgumentException("堆满了");
        }

        ++size;
        a[size] = data;
        int i = size;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public int removeMax() {

        if (size == 0) {
            return -1;
        }

        int res = a[1];

        a[1] = a[size];
        --size;
        heapify(size, 1);

        return res;
    }

    private void heapify(int n, int i) {
        while (true) {
            int maxPos = 1;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos += 1;
            }
            if (maxPos == 1) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(20);

        heap.insert(5);
        heap.insert(1);
        heap.insert(3);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);

        while (true) {
            int i = heap.removeMax();
            if (i == -1) {
                break;
            }
            System.out.print(i + ", ");
        }
    }
}
