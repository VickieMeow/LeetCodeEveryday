import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author miaomeiqi
 */
public class Solution179 {

    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            stringBuilder.append(strs[i]);
        }
        String s = stringBuilder.toString();
        int index = 0;
        while (index < s.length() - 1 && s.charAt(index) == '0') {
            index++;
        }
        return s.substring(index);
    }

}
