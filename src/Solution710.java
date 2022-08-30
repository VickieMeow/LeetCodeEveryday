import java.util.*;

/**
 * 黑名单中的随机数
 * @author miaomeiqi
 *
 * 总共有 n 个数，其中 m 个数不可被选，即真实可选个数为 n−m 个。
 *
 * 为了能够在 [0,n−m) 连续段内进行随机，我们可以将 [0,n−m) 内不可被选的数映射到 [n−m,n−1] 内可选的数上。
 *
 * 具体的，我们可以使用两个 Set 结构 s1 和 s2 分别记录在 [0,n−m) 和 [n−m,n−1] 范围内的黑名单数字。
 *
 * 在 pick 操作时，我们在 [0,n−m) 范围内进行随机，根据随机值 val 是否为黑名单内数字（是否在 s1 中）进行分情况讨论：
 *
 * 随机值 val 不在 s1 中，说明 val 是真实可选的数值，直接返回；
 * 随机值 val 在 s1 中，说明 val 是黑名单内的数值，我们先查询是否已存在 val 的映射记录，若已存在直接返回其映射值；
 * 否则需要在 [n−m,n−1] 内找到一个可替代它的数值，
 * 我们可以使用一个变量 idx 在 [n−m,n−1] 范围内从前往后扫描，找到第一个未被使用的，同时不在 s2 中（不在黑名单内）的数字，
 * 假设找到的值为 x，将 x 进行返回（同时将 val 与 x 的映射关系，用哈希表进行记录）。
 */

public class Solution710 {
    int n, m, idx;
    Random random = new Random();
    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    public Solution710(int _n, int[] bs) {
        n = _n; m = bs.length;
        int max = n - m;
        for (int x : bs) {
            if (x < max) {
                s1.add(x);
            } else {
                s2.add(x);
            }
        }
        idx = n - m;
    }
    public int pick() {
        int val = random.nextInt(n - m);
        if (!s1.contains(val)) {
            return val;
        }
        if (!map.containsKey(val)) {
            while (s2.contains(idx)) {
                idx++;
            }
            map.put(val, idx++);
        }
        return map.get(val);
    }
}
