package String;

import java.util.*;

/**
 * 第一个只出现一次的字符位置
 * 本题知识点： 字符串
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        String s = "google";
        FirstNotRepeatingChar solution = new FirstNotRepeatingChar();
        int index = solution.FirstNotRepeatingChar3(s);
        System.out.println(index);
    }

    /**
     * 使用HashMap
     * 空间复杂度：O(N)
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用整型数组
     * 空间复杂度：O(1)
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar2(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++){
            // 存储的是字符的ASSIC码，如a是97
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }

    /**
     * 使用比特位
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar3(String str) {
        BitSet bs1 = new BitSet(256); // 用于存第一次出现的字符
        BitSet bs2 = new BitSet(256); // 用于存以及出现过的字符
        for (char c : str.toCharArray()) {
//            System.out.println("bs1.get(c):"+bs1.get(c)); //存在返回true，不存在返回false
//            System.out.println("bs2.get(c):"+bs2.get(c));
            // 如果bs1没有&bs2没有，第一次出现，存入bs1中
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c);     // 0 0 -> 0 1
            // 如果bs1中有&bs2中没有，出现过的，存入bs2中
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);     // 0 1 -> 1 1
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 符合条件：只在bs1中&不在bs2中的，即只出现一次的
            if (bs1.get(c) && !bs2.get(c))  // 0 1
                return i;
        }
        return -1;
    }


}
