package String;

/**
 * @description: 翻转单词顺序列
 * @author: Kevin
 * @createDate: 2020/2/24
 * @version: 1.0
 */
public class ReverseSentence {

    public static void main(String[] args) {
        ReverseSentence solution = new ReverseSentence();
        String str = "I am a student.";
        System.out.println(solution.ReverseSentence(str));  // student. a am I
    }

    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            // 空格分割单词，或者为最后一个词
            if (chars[j] == ' ' || j == n) {
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
