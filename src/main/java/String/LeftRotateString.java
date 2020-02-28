package String;

/**
 * @description: 左旋转字符串
 * Input:
 * S="abcXYZdef"
 * K=3
 *
 * Output:
 * "XYZdefabc"
 * @author: Kevin
 * @createDate: 2020/2/23
 * @version: 1.0
 */
public class LeftRotateString {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        int n = 3;
        LeftRotateString solution = new LeftRotateString();
        String res = solution.LeftRotateString(str, n);
        System.out.println(res); // XYZdefabc
    }

    public String LeftRotateString(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

}
