import java.io.File;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/27
 * @version: 1.0
 */

class P {
    P() {
        super();
//         this();
    }
}

public class Test {

/*    public static void main(String ags[]) {
        String initial = "ABCDEFG", after = "";
        after = initial = initial.replace('A', 'Z');
        System.out.println(initial + ", " + after);
        // ZBCDEFG, ZBCDEFG
    }*/

/*    static int index = 0;

    public static void main(String args[]) {
        System.out.println(test());
    }

    int test() {
        int index = 1;
        return index;
    }*/

    static int test;
    static boolean afinal()
    {
        test++;
        return true;
    }

    public static void main(String[] args) {
        test = 0;
        if (( afinal () | afinal ()) ||afinal ())
        test++;
        System.out.println(test);
    }

    /*public static void main(String[] args) {
        String text = "199";
        try {
            text = text.concat(".5");
            double decimal = Double.parseDouble(text);
            text = Double.toString(decimal);
            int status = (int) Math.ceil(Double.valueOf(text).doubleValue());
            System.out.println(status);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }
    }*/

    /*public static void main(String args[]) {
        File sys = new File("/java/system");
        System.out.print(sys.canWrite());
        System.out.print(" " + sys.canRead());
//        false false
    }*/
}
