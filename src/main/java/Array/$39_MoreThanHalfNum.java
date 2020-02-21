package Array;

/**
 * 数组中出现次数超过一半的数字
 * 本题知识点： 数组
 * 链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?answerType=1&f=discussion
 * 来源：牛客网
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 思路：用一般的排序也可以完成这道题目，但是如果那样完成的话就可能太简单了。
 * 用majority记录上一次访问的值，count表明当前值出现的次数，如果下一个值和当前值相同那么count++；如果不同count--，减到0的时候就要更换新的majority值了，因为如果存在超过数组长度一半的值，那么最后majority一定会是该值。
 */
public class $39_MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int majority = array[0];//用来记录出现最多的值，初始值为第一个
        int count = 1;//majority出现的次数，初始值为1
        for (int i = 1; i < array.length; i++) {
            if (array[i] == majority)
                count++;
            else {
                count--;
                if (count == 0) {
                    majority = array[i];
                    count = 1;
                }
            }
        }
        System.out.println("majority num:" + majority);
        int num = 0;//需要判断是否真的是大于1半数
        for (int i = 0; i < array.length; i++)
            if (array[i] == majority)
                num++;
        return (num > array.length / 2) ? majority : 0;

    }

    public static void main(String[] args) {
        $39_MoreThanHalfNum solution = new $39_MoreThanHalfNum();
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = solution.MoreThanHalfNum_Solution(arr);
        System.out.println("more than  half num:" + res);
    }
}
