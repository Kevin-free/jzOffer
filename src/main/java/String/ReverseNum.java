package String;

/**
 * @description: 数字反转输出（超过integer的界限就返回0）
 * @author: Kevin
 * @createDate: 2020/3/12
 * @version: 1.0
 */
public class ReverseNum {

    public static void main(String[] args) {
        ReverseNum solution = new ReverseNum();
//        int r = solution.reverseNum(1234560789);
        int  r = solution.twoNum(1234560789);
        System.out.println(r);
    }

    public int twoNum(int x){
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
