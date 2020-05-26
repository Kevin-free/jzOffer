package String;

import java.util.Scanner;

/**
 * @description: 翻转单词顺序列
 * @author: Kevin
 * @createDate: 2020/2/24
 * @version: 1.0
 */
public class ReverseSentence {

    public static void main(String[] args) {
        ReverseSentence solution = new ReverseSentence();
//        Scanner s = new Scanner(System.in);
//        String str =  s.nextLine();
        String str = "I like beijing.";
        System.out.println(solution.ReverseSentence(str));  // beijing. like I
    }

    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            // 最后一个词，或者空格分割单词
            if (j == n || chars[j] == ' ') { // 注意！前后顺序不能反！ 否则 IndexOutOfBounds
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    /**
     * 翻转字符串
     *
     * @param chars 待翻转字符串
     * @param s     起点
     * @param e     终点
     */
    private void reverse(char[] chars, int s, int e) {
        while (s < e) {
            swap(chars, s++, e--);
        }
    }

    private void swap(char[] chars, int s, int e) {
        char t = chars[s];
        chars[s] = chars[e];
        chars[e] = t;
    }

}
