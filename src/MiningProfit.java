public class MiningProfit {
    public static void main(String[] args) {
        int time = 100;
        int gold = 200;
        int[][] upgradeOptions = {{0, 5}, {1500, 3}, {3000, 1}};

        int result = findMaxProfit(time, gold, upgradeOptions);
        System.out.println("Maximum profit: " + result);
    }

    public static int findMaxProfit(int time, int gold, int[][] upgradeOptions) {
        int[] dp = new int[time + 1];

        for (int i = 1; i <= time; i++) {
            dp[i] = dp[i - 1] + gold;  // 기본적으로 i초 동안 레벨 1 곡괭이로 캔 경우

            for (int[] upgrade : upgradeOptions) {
                int cost = upgrade[0];
                int efficiency = upgrade[1];

                if (i >= cost) {
                    dp[i] = Math.max(dp[i], dp[i - cost] + efficiency * gold);
                }
            }
        }

        return dp[time];
    }
}
