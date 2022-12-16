package 算法大赛;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(1);
        double pow2 = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            double pow = integer * Math.pow(2, i++);
            pow2 += pow;
        }
        int pow21 = (int) pow2;
        System.out.println(pow21);
    }

    public int getDecimalValue(ListNode head) {

        Deque<Integer> arr = new LinkedList<>();

        while (head.next != null) {
            arr.addLast(head.val);

            head = head.next;
        }
        int i = 0;
        double res = 0.0;
        while (arr.size() > 0) {
            Integer last = arr.removeLast();
            double pow = last * Math.pow(2, i++);
            res += pow;
        }
        return (int) res;
    }
}
