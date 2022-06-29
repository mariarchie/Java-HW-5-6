public class MergeSort {
    public static void main(String args[]) {
        int[] nums = { 5, 2, 3, 1, 9, 0 };

        HeapSort ob = new HeapSort();
        ob.sort(nums);

        System.out.println("Sorted array: ");
        printArray(nums);

    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void mergeSort(int[] nums, int n) {

        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] tempArray1 = new int[mid];
        int[] tempArray2 = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            tempArray1[i] = nums[i];
        }
        for (int i = mid; i < n; i++) {
            tempArray2[i - mid] = nums[i];
        }
        mergeSort(tempArray1, mid);
        mergeSort(tempArray2, n - mid);

        merge(nums, tempArray1, tempArray2, mid, n - mid);
    }

    public static void merge(int[] nums, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }
        while (i < left) {
            nums[k++] = l[i++];
        }
        while (j < right) {
            nums[k++] = r[j++];
        }
    }

}