package math;

import java.util.Scanner;

/**
 * @description: https://www.nowcoder.com/questionTerminal/46eb436eb6564a62b9f972160e1699c9?f=discussion
 * @author: Kevin
 * @createDate: 2020/3/25
 * @version: 1.0
 */
public class 序列和 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), L = in.nextInt();
        in.close();
//        boolean flag = false;
        for (int i = L; i <= 100; i++) {
            // 从 L 开始枚举，首项 a1 是否为整数
            if ((2 * N + i - i * i) % (2 * i) == 0) {
//                flag = true;
                int a1 = (2 * N + i - i * i) / (2 * i);
                for (int j = 0; j < i - 1; j++) {
                    int a = a1 + j;
                    System.out.print(a + " ");
                }
                System.out.println(a1 + i - 1);
                System.exit(0);
//                break;
            }
        }
//        if(flag == false)
        System.out.println("No");
    }

}
