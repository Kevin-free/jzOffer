package dynamicProgramming;

/**
 * @description: https://leetcode-cn.com/problems/unique-paths-ii/submissions/
 * 不同路径 II：带障碍
 * @author: Kevin
 * @createDate: 2020/3/25
 * @version: 1.0
 */
public class 不同路径2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length; // row 行数
        int c = obstacleGrid[0].length; // column 列数

        // 如果第一个就有障碍
        if (obstacleGrid[0][0] == 1)
            return 0;

        // 初始化第一个
        obstacleGrid[0][0] = 1;

        // 初始化第一列
        for (int i = 1; i < r; i++){
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
        }

        // 初始化第一行
        for (int j = 1; j < c; j++){
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < r; i++){
            for (int j = 1; j < c; j++){
                obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? obstacleGrid[i-1][j] + obstacleGrid[i][j-1] : 0;
            }
        }

        return obstacleGrid[r - 1][c - 1];

    }
}
