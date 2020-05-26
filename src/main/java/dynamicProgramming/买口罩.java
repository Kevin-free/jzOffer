package dynamicProgramming;

import java.util.Scanner;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/31
 * @version: 1.0
 */
public class 买口罩 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
//            System.out.println(n);

//            int[] dp = new int[n];

            if (n <= 0)
                System.out.println(0);

            if (n <= 2)
                System.out.println(5);
            else if (n <= 4)
                System.out.println(8);
            else if (n <= 6)
                System.out.println(11);
            else if (n <= 9)
                System.out.println(13);
            else if (n <= 11)
                System.out.println(14);
            else if (n <= 14)
                System.out.println(17);
            else
                System.out.println(18);

        }
    }
}
