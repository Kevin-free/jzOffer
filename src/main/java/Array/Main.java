package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 阿里笔试1
 * @author: Kevin
 * @createDate: 2020/3/25
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n列
        int[][] dp = new int[3][n];
        //int ans = 0, x;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int j = 1; j < n; j++) {
            int[] temp = new int[3];
            for (int i = 0; i < 3; i++){
                temp[i] = Math.min(Math.min(Math.abs(dp[i][j] - dp[0][j - 1]),Math.abs(dp[i][j] - dp[1][j - 1])),Math.abs(dp[i][j] - dp[2][j - 1]));
            }
            Arrays.sort(temp);
            int ansi = temp[0];
            ans += ansi;
        }
        System.out.println(ans);
    }
}
