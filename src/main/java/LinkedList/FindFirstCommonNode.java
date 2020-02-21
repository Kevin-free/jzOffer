package LinkedList;

import java.util.Collections;

/**
 * @description: 两个链表的第一个公共结点
 * 本题知识点： 链表
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @author: Kevin
 * @createDate: 2020/2/14
 * @version: 1.0
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {
        FindFirstCommonNode solution = new FindFirstCommonNode();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 3, 4};
        ListNode list1 = new ListNode(arr1);
        ListNode list2 = new ListNode(arr2);
        ListNode res = solution.FindFirstCommonNode(list1, list2);
        System.out.println("res list: "+res);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode l1 = pHead1,l2 = pHead2;
        while(l1 != l2){
            l1 = (l1==null ? pHead2 : l1.next);
            l2 = (l2==null ? pHead1 : l2.next);
        }
        return l1;
    }
}
