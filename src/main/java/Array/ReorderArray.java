package Array;

/**
 * @description: move all positive numbers to the left, and move all negative numbers to the right.
 * @author: Kevin
 * @createDate: 2020/2/18
 * @version: 1.0
 */
public class ReorderArray {

    public static void main(String[] args) {
        ReorderArray solution = new ReorderArray();
        int[] arr = {6, 4, -3, 5, -2, -1, 0, 1, -9};
        solution.reOrderArray(arr);
        for(int i : arr){
            System.out.print(i+", ");
            // 6, 4, 5, 0, 1, -3, -2, -1, -9,
        }
    }

    public void reOrderArray(int [] array) {
        int m = array.length;
        int k = 0; // 记录负数第一次出现的位置
        for (int i = 0; i < m; i++) {
            if (array[i] >= 0) {
                int j = i;
                // 将负数后面的正数往前移动
                while (j > k) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }

}
