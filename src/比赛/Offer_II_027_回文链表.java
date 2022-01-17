package 比赛;

public class Offer_II_027_回文链表 {
    //
    //public class ListNode {
    //    int val;
    //    ListNode next;
    //
    //    ListNode() {
    //    }
    //
    //    ListNode(int val) {
    //        this.val = val;
    //    }
    //
    //    ListNode(int val, ListNode next) {
    //        this.val = val;
    //        this.next = next;
    //    }
    //}
    //
    //ListNode ref;
    //
    //public boolean isPalindrome(ListNode head) {
    //    ref = head;
    //    return check(head);
    //}
    //
    //private boolean check(ListNode head) {
    //    if (head == null) {
    //        return false;
    //    }
    //
    //    boolean res = check(head.next);
    //
    //    boolean re2 = ref.val == head.val;
    //
    //    ref = head.next;
    //    return res && re2;
    //}

    //思考：对于不知道应该建立多大的数组 但是又需要建立数组的情况  可以建一个arraylist  这样可以少遍历一次

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        if (head == null) {
            return false;
        }
        while (head != null) {
            head = head.next;
            length++;
        }


        int[] arr = new int[length];
        int i = 0;
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }

        int a = 0;
        int b = length;

        while (a < b) {

            if (arr[a++] != arr[b--]) {
                return false;
            }
        }
        return true;
    }
}


