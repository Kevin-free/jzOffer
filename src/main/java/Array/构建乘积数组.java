package Array;

/**
 * @description: https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 构建乘积数组
 * @author: Kevin
 * @createDate: 2020/3/16
 * @version: 1.0
 */
public class 构建乘积数组 {

    public static void main(String[] s){
        构建乘积数组 solution = new 构建乘积数组();
        int[] A = {1, 2, 3, 4};
        int[] B = solution.multipy(A);
        for(int i:B){
            System.out.println(i);
        }
    }

    public int[] multipy(int[] A){
        int length = A.length;
        int[] B = new int[length];
        if(length != 0){
            B[0] = 1;
            // 计算下三角连乘
            for(int i = 1;i<length;i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            // 计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
