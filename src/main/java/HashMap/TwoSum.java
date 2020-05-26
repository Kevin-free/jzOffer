package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Kevin
 * @createDate: 2020/4/4
 * @version: 1.0
 */
public class TwoSum {

    public static void main(String [] args){
        TwoSum solution = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
        for (int i:res){
            System.out.print(i+",");
        }

    }

//    两遍哈希法
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int find = target - nums[i];
//            注：一遍哈希法时因为提前放值，必须判读 && map.get(find) != i，
//            以符合要求：不能重复利用这个数组中同样的元素
            if (map.containsKey(find) && map.get(find) != i){
                return new int[]{i,map.get(find)};
            }
        }
        throw new IllegalArgumentException("No two sum");
    }

//    一遍哈希法
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int find = target - nums[i];
            if (map.containsKey(find)){
                return new int[]{i,map.get(find)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum");
    }
}
