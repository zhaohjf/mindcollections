public void sort_practise(int[] a) {
        for (int i = (a.length >>> 1) - 1; i >= 0; i--) {
            sink(a, i, a.length);
        }
        int size = a.length - 1;
        while (size >= 0) {
            swap(a, 0, size);
            sink(a, 0, size--);
        }
    }

    public void sink(int[] a, int k, int size) {
        int half = size >>> 1;
        int x = a[k];
        while (k < half) {
            int child = (k << 1) + 1;
            int c = a[child];
            int right = child + 1;
            if (right < size && c < a[right]) {
                c = a[child = right];
            }
            if (x >= c) {
                break;
            }
            a[k] = c;
            k = child;
        }
        a[k] = x;
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        heap.sort_practise(arr);
        System.out.println();
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
