package Array;

import java.util.ArrayList;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/2/17
 * @version: 1.0
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        FindNumbersWithSum solution = new FindNumbersWithSum();
//        int[] array = {1, 2, 4, 7, 8, 11, 15};
//        int sum = 15;
        int[] array = {5,7,9,10,13};
        int sum = 25;
        ArrayList<ArrayList<Integer>> res = solution.FindNumbersWithSum(array, sum);
        System.out.println(res.toString());
    }

    public ArrayList<ArrayList<Integer>> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Error input!");
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(array[i]);
                list.add(array[j]);
                res.add(list);
                i++;
            }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }

        }
        return res;
    }
}
