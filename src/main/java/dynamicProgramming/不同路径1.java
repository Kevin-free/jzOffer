package dynamicProgramming;

import java.util.Arrays;

/**
 * @description: https://mp.weixin.qq.com/s?__biz=MzI2NjI5MzU2Nw==&mid=2247484292&idx=1&sn=db0ab35d70e0baa1faa5d212e1e06f16&chksm=ea911bd4dde692c20e9835f27a6b0d693a98d1fe6f7a9c96f96c4a0342c82ce27974d766ca0d&scene=126&sessionid=1583656901&key=7cbd3ce3316bb469598510b1360c03d8517907b5d88a44fdfadd388de49252531f048fcb1b1499a84543337336f3201d9dc1483e278276f32abcd74139d8518df3306aad5c49961f62c39ecdc8ec1003&ascene=1&uin=MjE2Mjc3OTYyNg%3D%3D&devicetype=Windows+10&version=6208006f&lang=zh_CN&exportkey=A006kzuDcnGtu9VvDi1aXFc%3D&pass_ticket=YK8M%2BvuU%2FU9YUteVP1Jys48omG7gwrzXaDFusp6lJpnntdy%2F%2FX5F4%2FRPyrEaxYcm
 * https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
 * 中等
 * tag: 数组、动态规划
 * @author: Kevin
 * @createDate: 2020/3/8
 * @version: 1.0
 */
public class 不同路径1 {
    public static void main(String[] a){
        不同路径1 solution = new 不同路径1();
        int m = 3, n = 7;
//        int res = solution.uniquePaths(m, n);
        int res = solution.uniquePaths2(m, n);
        System.out.println(res);
    }

    /**
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     * @param m 行数
     * @param n 列数
     * @return
     */
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        // 初始化第一列
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;  // 每行的第一个为1
        }
        // 初始化第一行
        for (int i = 0; i < n; i++){
            dp[0][i] = 1; // 每列的第一个为1
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 空间复杂度 O(n)
    public int uniquePaths2(int m, int n){
        // 构建一个列长的一维数组（减少空间）
        int[] dp = new int[n];
//        Arrays.fill(dp, 1); //
        // 初始化第一行每列的值为1
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        // 从第二行开始，动态计算每一列的值
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }

}
