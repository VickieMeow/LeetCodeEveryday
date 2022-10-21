public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return intervals;
        }
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int L = newInterval[0];
        int R = newInterval[1];
        List<int[]> res = new ArrayList<>();
        int index = 0;
        while (index < intervals.length && intervals[index][1] < L) {
            res.add(intervals[index++]);
        }
        while (index < intervals.length && intervals[index][0] <= R) {
            L = Math.min(intervals[index][0], L);
            R = Math.max(intervals[index++][1], R);
        }

        res.add(new int[]{L,R});

        while(index < intervals.length) {
            res.add(intervals[index++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}