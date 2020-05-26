package Array;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/28
 * @version: 1.0
 */
public class 旋转数组最小值 {

    public static void main(String[] args) {
        旋转数组最小值 solution = new 旋转数组最小值();
        int[] nums = {7, 0, 1, 2, 4, 5, 6};
//        int res = solution.findMin(nums);
        int res = solution.findMin1(nums);
//        int res = solution.findMin2(nums);
        System.out.println(res);

    }

    public int findMin(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l)>>1;
            if (nums[mid] > nums[r]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }

    public int findMin1(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l)>>1;
            if (nums[mid] > nums[l]){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return nums[r+1];
    }

    public int findMin2(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) >> 1;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return nums[l];
    }

}
