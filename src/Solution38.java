/**
 * @author miaomeiqi
 */
public class Solution38 {

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(2));
    }


    /**
     * 3322251  => 23321511
     * @param n 对n-1的描述
     */
    public String countAndSay(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] dp = new String[n+1];
        dp[1] = "1";
        for (int i = 2; i <= n; i++) {
            String preStr = dp[i-1];
            int counter = 1;
            for (int j = 0; j < preStr.length() - 1; j++) {
                int pointer = j+1;
                if (preStr.charAt(pointer) == preStr.charAt(j)) {
                    counter++;
                } else {
                    stringBuilder.append(counter);
                    stringBuilder.append(preStr.charAt(j));
                    counter = 1;
                }
            }
            stringBuilder.append(counter);
            stringBuilder.append(preStr.charAt(preStr.length()-1));
            dp[i] = stringBuilder.toString();
            stringBuilder  = new StringBuilder();
        }
        return dp[n];
    }

}
