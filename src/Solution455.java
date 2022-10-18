import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int child_count = 0;
        int cookie_count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (child_count < g.length && cookie_count < s.length) {
            if(g[child_count] <= s[cookie_count]) {
                child_count ++;
                cookie_count ++;
                count ++;
            }
            else  cookie_count++;
        }
        return count;
    }
}
