package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 数组中只出现一次的数字 （中等）
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author: Kevin
 * @createDate: 2020/2/20
 * @version: 1.0
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        FindNumsAppearOnce solution = new FindNumsAppearOnce();
        int[] array = {2, 1, 2, 3, 4, 4};
        int[] num1=new int[1],num2=new int[1];
        solution.FindNumsAppearOnce(array,num1,num2);
        int res[] = new int[2];
        solution.singleNumber(array);
    }

    // 位运算解法
    // 时间复杂度：O(N) 的时间遍历输入数组。
    // 空间复杂度：O(1)。
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null ||array.length<2)
            return ;
        int temp = 0;
        for(int i=0;i<array.length;i++)
            temp ^= array[i];

        int indexOf1 = findFirstBitIs(temp);
        for(int i=0;i<array.length;i++){
            if(isBit(array[i], indexOf1))
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
    }
    // 找到结果数中第一个为 1 的位的位置
    public int findFirstBitIs(int num){
        int indexBit = 0;
        while(((num & 1)==0) && (indexBit)<8*4){
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }
    // 判断数组中的数num 二进制第indexBit位是否为1
    public boolean isBit(int num,int indexBit){
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    // 哈希表解法
    // 时间复杂度：O(N)。
    // 空间复杂度：O(N)，
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap();
        for (int n : nums)
            hashmap.put(n, hashmap.getOrDefault(n, 0) + 1);

        int[] output = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> item : hashmap.entrySet())
            if (item.getValue() == 1) output[idx++] = item.getKey();

        return output;
    }

}
