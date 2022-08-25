/**
 * @author miaomeiqi
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] versionArr1 = version1.split("\\.");
        String[] versionArr2 = version2.split("\\.");
        int i = 0;
        for (; i < (Math.min(versionArr1.length, versionArr2.length)) ; i++) {
            String v1 = versionArr1[i];
            String v2 = versionArr2[i];
            // 如果v1>v2
            if (compareTwo(v1, v2) == 1) {
                return 1;
            } else if (compareTwo(v1, v2) == 0) {
                continue;
            } else {
                return -1;
            }
        }
        while (i < versionArr1.length) {
            if (compareTwo(versionArr1[i], "") > 0) {
                return 1;
            }
            i++;
        }
        while (i < versionArr2.length) {
            if (compareTwo(versionArr2[i], "") > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public int compareTwo(String v1, String v2) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < v1.length(); i++) {
            num1 *= 10;
            num1 += (v1.charAt(i) - '0');
        }
        for (int i = 0; i < v2.length(); i++) {
            num2 *= 10;
            num2 += (v2.charAt(i) - '0');
        }
        return Integer.compare(num1, num2);
    }

    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            for (int i = 0; i < v1.length || i < v2.length; ++i) {
                int x = 0, y = 0;
                if (i < v1.length) {
                    x = Integer.parseInt(v1[i]);
                }
                if (i < v2.length) {
                    y = Integer.parseInt(v2[i]);
                }
                if (x > y) {
                    return 1;
                }
                if (x < y) {
                    return -1;
                }
            }
            return 0;
        }
    }

}
