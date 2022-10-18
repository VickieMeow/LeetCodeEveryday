public class Solution322 {

    //1.动态规划
    //利用已算出的f[amount]推算新的f[amount]
    //f[amount] = f[amount - coin] + 1
    public int coinChange(int[] coins, int amount) {
        int [] f = new int[amount + 1];
        f[0] = 0;

        for(int i = 1; i <= amount; i++){
            //初始化cost，用于暂存对于本层amount的当前最优解
            int cost = Integer.MAX_VALUE;
            //对当前的amount，循环遍历每一种情况，选出最小值，如果不存在则f[amount] = Integer.MAX_VALUE
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    if(f[i-coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }
            f[i] = cost;
        }
        return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];
    }
}
