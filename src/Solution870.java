import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 优势洗牌
 * 和田忌赛马一个思想，从最好的开始比，能比得过就用，比不过就用最烂的代替
 * @author miaomeiqi
 */
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 给nums2排序
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < nums2.length; i++){
            int[] pair = new int[2];
            pair[0] = i;
            pair[1] = nums2[i];
            maxHeap.add(pair);
        }
        Arrays.sort(nums1);
        int left = 0, right = nums1.length - 1;
        int[] res = new int[nums1.length];
        while (!maxHeap.isEmpty()) {
            int[] pair = maxHeap.poll();
            if (nums1[right] > pair[1]) {
                res[pair[0]] = nums1[right];
                right--;
            } else {
                res[pair[0]] = nums1[left];
                left++;
            }
        }
        return res;
    }
}