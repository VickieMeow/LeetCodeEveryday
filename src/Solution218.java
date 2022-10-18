import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }
        int[][] buildingsCopy = Arrays.copyOf(buildings, buildings.length);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPoint = new ArrayList<>();
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        curPoint.add(buildingsCopy[0][0]);
        curPoint.add(buildingsCopy[0][2]);
        res.add(new ArrayList<>(curPoint));
        for (int i = 1; i < buildingsCopy.length; i++) {
            int[] pivot = buildingsCopy[i];
            int left = pivot[0];
            int right = pivot[1];
            int height =  pivot[2];
            int leftPoint = left;

            if (left > buildingsCopy[i-1][1]) {
                curPoint.clear();
                curPoint.add(buildingsCopy[i-1][1]);
                curPoint.add(0);
                if (res.get(res.size()-1).get(1) != 0) {
                    res.add(new ArrayList<>(curPoint));
                }
                curPoint.clear();
                curPoint.add(left);
                curPoint.add(height);
                if (res.get(res.size()-1).get(1) != height) {
                    res.add(new ArrayList<>(curPoint));
                }
                continue;
            }


            for (int j = 0; j < buildings.length; j++) {
                if (buildings[j][0] > left) {
                    break;
                }
                if (buildings[j][1] < right && buildings[j][2] > height) {
                    leftPoint = Math.max(buildings[j][1], leftPoint);
                }
            }
            curPoint.clear();
            curPoint.add(leftPoint);
            curPoint.add(height);
            if (res.get(res.size()-1).get(1) != height) {
                res.add(new ArrayList<>(curPoint));
            }
        }

        curPoint.clear();
        curPoint.add(buildings[buildings.length-1][1]);
        curPoint.add(0);
        if (res.get(res.size()-1).get(1) != 0) {
            res.add(new ArrayList<>(curPoint));
        }
        return res;
    }

}
