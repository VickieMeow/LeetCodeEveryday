import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution239 {

    //1.暴力法
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }


    //2.双端队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || k <= 0) return (new int[0]);
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int res_index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0;i < n ;i++){
            //去除不在窗口内的元素
            while (!q.isEmpty() && q.peek() < i - k +1) q.poll();
            //去除队列中小于当前元素的元素
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offer(i);
            if(i >= k - 1) res[res_index++] = nums[q.peek()];
        }
        return res;
    }

    //3.动态规划
    public int[] maxSlidingWindow3(int[] nums, int k) {
        return null;
    }


}
