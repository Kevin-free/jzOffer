package Array;

import java.util.ArrayList;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/2/17
 * @version: 1.0
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        FindContinuousSequence solution = new FindContinuousSequence();
        int sum = 15;
        ArrayList<ArrayList<Integer>> res = solution.FindContinuousSequence(sum);
        System.out.println(res.toString());
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        int plow = 1,phigh = 2;
        while(phigh > plow){
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }else if(cur < sum){
                phigh++;
            }else{
                plow++;
            }
        }
        return result;
    }

}
