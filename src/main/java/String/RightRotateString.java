package String;

/**
 * @description: 自举：右旋转字符串
 *  * Input:
 *  * S="abcXYZdef"
 *  * K=3
 *  *
 *  * Output:
 *  * "defabcXYZ"
 * @author: Kevin
 * @createDate: 2020/2/23
 * @version: 1.0
 */
public class RightRotateString {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        int n = 3;
        RightRotateString solution = new RightRotateString();
        String res = solution.RightRotateString(str, n);
        System.out.println(res); // defabcXYZ
    }

    public String RightRotateString(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        int l = chars.length;
        reverse(chars, l - n, l - 1);
        reverse(chars, 0, l - n - 1);
        reverse(chars, 0, l - 1);
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
