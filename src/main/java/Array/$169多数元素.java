package Array;

import java.util.*;

/**
 * @description: https://leetcode-cn.com/problems/majority-element/
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * @author: Kevin
 * @createDate: 2020/3/13
 * @version: 1.0
 */
public class $169多数元素 {
    public static void main(String[] args) {
        $169多数元素 solution = new $169多数元素();
//        int[] arr = {2, 5, 1, 4, 3};
//        solution.quickSort(arr, 0, arr.length - 1);
//        for(int i:arr){
//            System.out.println(i);
//        }
        Map<String,Integer> hashMap = new HashMap<>(3);
        hashMap.put("a", 1);
        System.out.println(hashMap.size());

//        int[] nums = {2,2,1,1,1,2,2};
//        int res = solution.majorityElement(nums);
//        System.out.println(res);
    }

    public int majorityElement(int[] nums) {
        // HashMap统计法
//        return hashMapMethod(nums);

        // 排序法，取中位数
//        Arrays.sort(nums);
//        return nums[nums.length / 2];

        // 投票法
        return mooreMethod(nums);

    }

    // 哈希表统计法
    private int hashMapMethod(int[] nums){
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
//        return counts;
        Map.Entry<Integer,Integer> majority = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(majority == null || majority.getValue() < entry.getValue()){
                majority = entry;
            }
        }
        return majority.getKey();
    }

    // moore投票算法
    private int mooreMethod(int[] nums) {
        int count = 1;
        int res = nums[0];
        for(int i =1;i<nums.length;i++){
            count += (res==nums[i])? 1 : -1;
            if(count == 0){
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}
