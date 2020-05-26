package bit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/11
 * @version: 1.0
 */
public class Add {

    public static void main(String[] args) {
        Add solution = new Add();
        int sum = solution.Add(5, 7);
        /**
         * 5-101
         * 7-111
         *
         *   5-101    101
         * ^ 7-111  & 111
         * = 2-010  = 101 <<1 = 10-1010
         *
         *    2-0010    0010
         * ^ 10-1010  & 1010
         * =  8-1000  = 0010 <<1 = 4-0100
         *
         *    8-1000    1000
         * ^  4-0100  & 0100
         * = 12-1100  = 0000 <<1 = 0-0000 ==》》return 12-1100
         */
        System.out.println(sum);
    }

    // 不用加减乘除做加法，位运算
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2; // 相加各位的值，不算进位
            num2 = (num1 & num2) << 1; // 计算进位值
            num1 = temp;
        }
        return num1;
    }

    /**
     * 使用AtomicInteger.
     */
    public int addV2(int a, int b) {
        AtomicInteger ai = new AtomicInteger(a);
        return ai.addAndGet(b);
    }
}
