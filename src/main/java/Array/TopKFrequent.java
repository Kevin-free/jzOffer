package Array;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @description: 前 K 个高频元素  (中等)
 * 本题知识点：数组、哈希、堆
 * @author: Kevin
 * @createDate: 2020/2/24
 * @version: 1.0
 */
public class TopKFrequent {

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();
        int[] nums = {1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 5};
        int k = 3;
        List<Integer> res = solution.TopKFrequent(nums, k);
        System.out.println(res); //[5, 3, 1]
    }

    // 解决方法
    public List<Integer> TopKFrequent(int[] nums, int k) {
        // 1. 使用 map 统计频率
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 2. 根据频率，将频率添加到优先队列（Java默认实现最小堆）
        PriorityQueue<Integer> pq = new PriorityQueue<>(
//                (o1, o2) -> map.get(o1) - map.get(o2)
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        // 按照频率，小的在前 (即 默认升序)
                        return map.get(o1) - map.get(o2);
                    }
                }
        );
        for (int key : map.keySet()) {
            // 如果队列中元素个数未到k，直接添加
            if (pq.size() < k) {
                pq.add(key);
            }
            // 达到k数，判断下一个值是否大于队首值，大于则将队首值删除，将此值添加
            else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.add(key);
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res); // 翻转数组，输出结果频率由高到低
        return res;
    }
}
