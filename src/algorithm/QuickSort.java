public class QuickSort {

    public int partitional(int nums[], int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                --high;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public void quickSort(int nums[], int low, int high) {
        if (low < high) {
            int pivot = partitional(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);

        }
    }


}