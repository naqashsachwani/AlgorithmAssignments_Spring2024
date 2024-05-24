public class QuickSort {

    // Function to partition the array
    private static int partition(int[] arr, int l, int h) {
        int p = arr[h]; // Set pivot element
        int i = (l - 1); // Index for smaller element

        for (int j = l; j < h; j++) {
            // If current element is less than or equal to pivot
            if (arr[j] <= p) {
                i++;

                // Swap elements at arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the element at arr[i + 1]
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;

        return i + 1; // Return the partition index
    }

    // Function to perform QuickSort
    private static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            // Find partition index
            int pi = partition(arr, l, h);

            // Recursively sort elements before and after the partition
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, h);
        }
    }

    // Main function to test the QuickSort implementation
    public static void main(String[] args) {
        int[] data = {2, 8, 7, 1, 3, 5, 6, 4};

        System.out.println("Unsorted array:");
        for (int n : data) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Execute QuickSort
        quickSort(data, 0, data.length - 1);

        System.out.println("Sorted array:");
        for (int n : data) {
            System.out.print(n + " ");
        }
    }
}
