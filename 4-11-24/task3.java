import java.util.Random;

public class task3 {
    
    public static int findKthSmallest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        return quickselect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickselect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickselect(arr, left, pivotIndex - 1, k);
        } else {
            return quickselect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("The " + k + "rd smallest element is " + findKthSmallest(arr, k));
    }
}
