package leetcode.offer;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Offer06_从尾到头打印链表 {

    //递归   很耗时 和 耗费空间
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> integers = printListFromTailToHead(head);
        int size = integers.size();
        //Integer[] ints = new Integer[size];
        //Integer[] integers1 = integers.toArray(ints);

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            //result[i] = integers[i].intValue();
            result[i] = integers.get(i);
        }
        return result;
    }
    //递归结束

    //法二：栈
    public int[] reversePrint1(ListNode head) {

        if (head == null) {
            return new int[0];
        }

        //要求是返回数组的话判断是否为空不要返回null 返回上面的
        // if (head == null) {
        //     return null;
        // }
        //栈也要指定存储类型
        Stack<ListNode> listNodes = new Stack<>();
        while (head != null) {
            listNodes.push(head);
            head = head.next;
        }

        int size = listNodes.size();

        int[] ints = new int[size];
        //listNodes.peek() != null  会导致空指针异常 不能用这个判断
        //int i = 0;
        //while (listNodes.peek() != null) {
        //    ints[0] = listNodes.pop().val;
        //    i++;
        //}

        for (int i = 0; i < size; i++) {
            ints[i] = listNodes.pop().val;
        }
        return ints;
    }

    //时间复杂度：O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
    //空间复杂度：O(n)。额外使用一个栈存储链表中的每个节点。
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-b/


    //法三：
    //java无需借助Stack和ArrayList双100解法

    public int[] reversePrint2(ListNode head) {
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while (currNode != null) {
            len++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while (currNode != null) {
            result[len - 1] = currNode.val;
            len--;
            currNode = currNode.next;
        }
        return result;
    }

    //另外不使用栈，直接使用ArrayList也是可行，从ArrayList中倒序取出
    public int[] reversePrint3(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(size - i - 1);
        }
        return array;
    }

    //题解中Stack中元素类型为ListNode，可以替换为直接保存val的类型Integer
    public int[] reversePrint4(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    //递归思想


}
