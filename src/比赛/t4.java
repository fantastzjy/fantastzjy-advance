package 比赛;

import java.util.ArrayList;

public class t4 {
    public String getHappyString(int n, int k) {

        char[] arr = {'a', 'b', 'c'};
        String res = "";
        ArrayList<String> ll = new ArrayList<>();

        getstr(arr, n, res, ll);
        if (ll.size() >= k) {
            res = ll.get(k - 1);
        }
        return res;
    }

    private void getstr(char[] arr, int n, String res, ArrayList<String> ll) {

        if (n == 0) {
            ll.add(res);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (res.equals("") || res.charAt(res.length() - 1) != arr[i]) {
                String pre = res + arr[i];
                getstr(arr, n - 1, pre, ll);
            }
        }

    }


}