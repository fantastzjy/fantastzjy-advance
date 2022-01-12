package 比赛;

public class t1 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode ref;

    public boolean isPalindrome(ListNode head) {
        ref = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return false;
        }

        boolean res = check(head.next);

        boolean re2 = ref.val == head.val;

        ref = head.next;
        return res && re2;
    }

    //    int length = 0;
    //    if (head == null) {
    //        return false;
    //    }
    //    while (head != null) {
    //        head = head.next;
    //        length++;
    //    }
    //    if (length == 1) {
    //        return true;
    //    }
    //    int[] arr = new int[length];
    //    int i = 0;
    //    while (head != null) {
    //        arr[i++] = head.val;
    //        head = head.next;
    //    }
    //    int a = 0;
    //    int b = length-1;
    //
    //    while (a<b) {
    //
    //        if (arr[a++] != arr[b--]) {
    //            return false;
    //        }
    //    }
    //    return true;
    //}


}
