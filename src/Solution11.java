public class Solution_11 {


    //1.双指针夹逼法
//头指针i，尾指针j，谁指向的棒子高度小，谁向内收敛
// 因为只有内部的棒子比外部棒子高，才有可能面积更大
    public int maxArea1(int[] height) {
        int res = 0;
        for(int i = 0,j = height.length-1;i < j;){
            int minHeight = height[i] < height[j] ? height[i++]:height[j++];
            int res_temp = minHeight * (j - i +1);
            res = Math.max(res,res_temp);
        }
        return res;
    }

    //2.暴力法
//主要注意如何枚举一个数组中两个不相同元素
    public int maxArea2(int[] height) {
        int res = 0;
        for(int i = 0;i < height.length - 1;i++){
            for(int j = i+1;j < height.length;j++){
                res = Math.max(res,Math.min(height[i],height[j])*(j-i));
            }
        }
        return res;
    }




}
