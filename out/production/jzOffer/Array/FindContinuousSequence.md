### 题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

### 输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

### 解题思路
注意题中的关键信息 ==“连续正数序列”== ，==“从小至大的顺序”== ，可以用到一种巧妙的==双指针技术==。双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。

实现代码
```java
package Array;

import java.util.ArrayList;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/2/17
 * @version: 1.0
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        FindContinuousSequence solution = new FindContinuousSequence();
        int sum = 15;
        ArrayList<ArrayList<Integer>> res = solution.FindContinuousSequence(sum);
        System.out.println(res.toString());
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        int plow = 1,phigh = 2;
        while(phigh > plow){
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }else if(cur < sum){
                phigh++;
            }else{
                plow++;
            }
        }
        return result;
    }

}
```

**图解**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200221211429678.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NDUyNTg0,size_16,color_FFFFFF,t_70)