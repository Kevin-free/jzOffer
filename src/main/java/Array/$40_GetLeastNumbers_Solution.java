package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * 本题知识点： 数组 高级算法
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class $40_GetLeastNumbers_Solution {

    public static void main(String[] args) {
        $40_GetLeastNumbers_Solution solution = new $40_GetLeastNumbers_Solution();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> res = solution.GetLeastNumbers_Solution(arr, k);
        System.out.println("res:" + res); // [4,3,1,2]
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // 并非从小到大排序，确保维持队首值为最大值
            }
        });
        for (int i = 0; i < length; i++) {
            // 如果队列中元素个数未到k，直接添加
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            }
            // 达到k数，判断下一个值是否小于队首值，小于则将队首值删除，将此值添加
            else if (input[i] < maxHeap.peek()) {
                Integer temp = maxHeap.poll();
                temp = null; //GC回收
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
