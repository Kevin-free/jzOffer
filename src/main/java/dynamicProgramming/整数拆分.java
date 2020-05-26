package dynamicProgramming;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/10
 * @version: 1.0
 */
public class 整数拆分 {

    public static void main(String[] args) {
        整数拆分 solution = new 整数拆分();
//        int res = solution.integerBreak0(10);
        int res = solution.integerBreak(10);
        System.out.println(res);
    }

    // 数学解法
    public int integerBreak0(int n){
        if(n<3) return n-1;
        int x = n / 3, y = n % 3;
        // 恰好整除，直接为 3^x
        if (y == 0) return (int) Math.pow(3, x);
        // 余数为1，退一步为 3^(x-1) *2*2
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        // 余数为2, 直接乘以2
        return (int) Math.pow(3, x) * 2;
    }

    // dp解法
    public int integerBreak(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++){
                // 将 i 分解为 j 和 i-j，分别求解
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));  // 等价于下式
//                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (Math.max((i - j), (i - j))));
            }
        }
        return dp[n];
    }
}
