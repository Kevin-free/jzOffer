package dynamicProgramming;

import java.util.Scanner;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/31
 * @version: 1.0
 */
public class 三角之和 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] sarr = line.split(",");
        int[] intarr = new int[sarr.length];
        for (int i = 0; i <sarr.length; i++) {
            intarr[i] = Integer.parseInt(sarr[i]);
        }
        int sum1 = intarr[0]+intarr[1]+intarr[2]+intarr[3];
        int sum2 = intarr[3]+intarr[4]+intarr[5]+intarr[6];
        int sum3 = intarr[6]+intarr[7]+intarr[8]+intarr[0];
        if (sum1 == sum2 && sum2 == sum3)
            System.out.println("yes");
        else
            System.out.println("no");

    }
}
