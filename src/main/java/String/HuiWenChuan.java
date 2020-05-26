package String;

import java.util.Scanner;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/27
 * @version: 1.0
 */

public class HuiWenChuan {
    static String string;
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        String s;
        System.out.println("请输入要检验的串：");
        string = scanner.next();
        if (huiWenChuan(string)) {
            s = "此字符串是回文串！";
        }else {
            s = "此字符串不是回文串！";
        }
        System.out.println(s);

    }

    private static boolean huiWenChuan(String string) {
        int low = 0;
        int high = string.length()-1;
        while (low<high) {
            if (string.charAt(low)!=string.charAt(high)){
                return false;

            }
            low++;
            high--;

        }
        return true;

    }
}

