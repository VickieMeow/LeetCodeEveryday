import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();

    }

    public int romanToInt(String s) {
        int length = s.length();
        int res = 0;
        for (int i = 1; i < length; i++) {
            Character c = s.charAt(i-1);
            Character next = s.charAt(i);
            if(map.get(c) < map.get(next)) {
                res-=map.get(c);
            } else {
                res+=map.get(c);
            }
        }
        return res;
    }

    private void initMap() {
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
}