import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution1122 {
    //1.计数排序
    //已知arr1中每个数的范围，且均为整数
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

    //2.使用hash表存储
    //适用于没有给出arr1中元素范围
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        if(arr2.length == 0) return arr1;
        int[] res = new int[arr1.length];
        Map<Integer,Integer> map = new HashMap<>();
        //初始化map，key为arr1中每个数字，value为每个数字出现的个数
        for(int n : arr1) map.put(n,map.getOrDefault(n,0) + 1);
        Arrays.sort(arr1);
        int index = 0;
        for(int n : arr2) {
            while(map.get(n) > 0) {
                res[index ++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        for(int i = 0;i<arr1.length;i++) {
            if(map.get(arr1[i]) != 0) res[index++] = arr1[i];
        }
        return res;
    }


}
