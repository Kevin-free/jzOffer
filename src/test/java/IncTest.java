/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/2/22
 * @version: 1.0
 */
public class IncTest {
    public static void main(String[] args) {
        IncTest inc = new IncTest();
        int i = 0;
        inc.fermin(i);
        i=  ++i;
        System.out.println(i);

    }
    void fermin(int i){
        i++;
    }
}
