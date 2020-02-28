package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 本题知识点： 数组
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] arr = {3, 321, 32};
        PrintMinNumber solution = new PrintMinNumber();
        String res = solution.PrintMinNumber(arr);
        System.out.println(res);
    }

    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2); //默认升序排序，s1 < s2，所以str1 < str2
//                return s2.compareTo(s1);
            }
        });

        for (int j : list) {
            s += j;
        }
        return s;

    }
}
