import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 380 0(1)时间插入、删除和获取随机元素
 * 使用hashmap+arrayList
 * @author miaomeiqi
 */
public class Solution380 {
    class RandomizedSet {
        ArrayList<Integer> arr;
        HashMap<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            arr = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                arr.add(val);
                map.put(val, arr.size() - 1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int temp = arr.get(arr.size() - 1);
            arr.set(index, temp);
            arr.set(arr.size() - 1, val);
            arr.remove(arr.size() - 1);
            map.put(temp, index);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int i = random.nextInt(arr.size());
            return arr.get(i);
        }
    }
}
