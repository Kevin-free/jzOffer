package Array;

import java.util.ArrayList;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/2/22
 * @version: 1.0
 */
public class MyFindNumbersWithSum {

    public static void main(String[] args) {
          MyFindNumbersWithSum solution = new MyFindNumbersWithSum();
        int[] array = {1, 2, 4, 7, 11, 16};
        int sum = 10;
        ArrayList<Integer> res = solution.FindNumbersWithSum(array, sum);
        System.out.println(res);
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array == null || array.length ==0)    return null;
        ArrayList<Integer> res = new ArrayList<>();
        int plow = 0,phigh = 1;
        while(plow<phigh){
            int cur = array[plow] + array[phigh];
            if(cur==sum){
                res.add(array[plow]);
                res.add(array[phigh]);
                return res;
            }
            else if(cur<sum){
                phigh ++;
            }else{
                plow ++;
            }
        }
        return res;
    }
}
