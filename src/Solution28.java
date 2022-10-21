class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        int res = -1;
        int haystackIndex = 0;
        int needleLen = needle.length();
        while (haystackIndex < haystack.length()) {
            if (haystackIndex+needleLen <= haystack.length() && haystack.substring(haystackIndex, haystackIndex+needleLen).equals(needle)) {
                return haystackIndex;
            }
            haystackIndex++;
        }
        return -1;
    }
}
