//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
public class Solution189 {
    //1.暴力法
    public void rotate1(int[] nums, int k) {
        while (k > 0){
            int temp = nums[nums.length-1];
            for(int i = nums.length-1 ; i > 0 ;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }

    //2.分段翻转法
    //先整体翻转，后分别翻转前k个元素和后面的元素
    public void rotate2(int[] nums,int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;end--;
        }
    }

    //3.环状替换
    //从第一个元素开始，不断将元素放到它应该在的位置上去，count用来保证交换次数
    //prev_value为当前待处理的元素值
    //current为当前待处理的元素下标
    //next为当前待处理元素马上应该被放到的位置下标
    //如果start==current，说明nums.length为k的倍数，出现闭环，则start应该加一，继续处理下一元素
    public void rotate3(int[] nums, int k){
        k %= nums.length;
        int count = 0;
        for(int start = 0;count < nums.length;start++){
            int current = start;
            int prev_value = nums[current];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev_value;
                prev_value = temp;
                current = next;
            }while (start != current);
        }
    }




}

