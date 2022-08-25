import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2028 {

    public static void main(String[] args) {
        int[] rolls = new int[]{3,2,4,3,1,5,2,5,4,2};
        int mean = 4;
        int n = 5;
        Solution2028 solution2028 = new Solution2028();
        System.out.println(Arrays.toString(solution2028.missingRolls(rolls, mean, n)));
    }
    List<Integer> tempRes = new ArrayList<>();
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int sum = (rolls.length + n) * mean;
        for (int i = 0; i < rolls.length; i++) {
            sum -= rolls[i];
        }
        dfs(new ArrayList<Integer>(), sum, n);
        if (tempRes.size() < n) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            res[i] = tempRes.get(i);
        }
        return res;
    }

    public void dfs(List<Integer> path, int sum, int n) {
        if (sum == 0 && path.size() == n) {
            tempRes.addAll(path);
            return;
        }
        if (sum < 0) {
            return;
        }
        if (path.size() > n) {
            return;
        }
        for (int i = 1; i <= 6; i++) {
            path.add(i);
            dfs(path, sum-i, n);
            path.remove(path.size()-1);
        }
        return;
    }
}
