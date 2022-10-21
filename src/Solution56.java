import java.util.ArrayList;
import java.util.Arrays;

public class Solution_56 {


    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) return new int[0][0];
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] interval : intervals) {
            if(interval[0] <= end) {
                end = Math.max(interval[1],end);
            }
            else {
                res.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][2]);

    }


}
