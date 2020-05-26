package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/4/4
 * @version: 1.0
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = -1;
        List<List<Integer>> res = solution.fourSum(nums, target);
        System.out.println(res);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4)
            return res;
        int a, b, c, d, length = nums.length;
        for (a = 0; a <= length-4; a++){
            // 确保 nums[a] 变了
            if (a>0 && nums[a] == nums[a -1 ])  continue; // 注意不能用break
            for (b = a + 1; b <= length - 3; b++) {
                // 确保 nums[b] 变了
                if (b>a+1 && nums[b] == nums[b-1])  continue; // 注意不能用break
                c = b+1; d = length -1;
                while (c < d){
                    if (nums[a] + nums[b]+nums[c]+ nums[d] < target){
                        c++;
                    }else if(nums[a] + nums[b]+nums[c]+ nums[d] > target){
                        d--;
                    }else{
                        res.add(Arrays.asList(nums[a],nums[b],nums[c], nums[d]));
                        // 确保 nums[c] 变了
                        while (c < d && nums[c] == nums[c+1])
                            c++;
                        // 确保 nums[d] 变了
                        while (c < d && nums[d] == nums[d-1])
                            d--;
                        c++;
                        d--;
                    }
                }

            }
        }
        return res;
    }
}
