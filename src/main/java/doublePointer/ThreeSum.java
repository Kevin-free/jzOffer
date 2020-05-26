package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Kevin
 * @createDate: 2020/4/4
 * @version: 1.0
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int target = 0 - nums[i];
            int left = i+1;
            int right = nums.length - 1;
            // 若第一个数大于0，不可能有满足条件解
            if (nums[i] > 0)
                break;
            // 判读下一个数是否重复，重复跳过
            if (i == 0 || nums[i] != nums[i - 1]){
                while (left < right){
                    if (nums[left] + nums[right] == target){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 一下两个while必须加，去重，否则不满足要求
                        // 答案中不可以包含重复的三元组。
                        while (left<right && nums[left] == nums[left+1]) left++;
                        while (left<right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
