package Array;

/**
 * @description: 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 * [[1,2,3],[0,1,2],[0,0,1]]
 * 返回：[[0,0,3],[0,0,0],[0,0,0]]
 * @author: Kevin
 * @createDate: 2020/3/8
 * @version: 1.0
 */
public class Clearer {

    public int[][] clearZero(int[][] mat, int n) {
        boolean[] row = new boolean[n];
        boolean[] column = new boolean[n];
        for(int i=0; i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    row[i]=true;
                    column[j]=true;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(row[i]||column[j])
                {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }
}
