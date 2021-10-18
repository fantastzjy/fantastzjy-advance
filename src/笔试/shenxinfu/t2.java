package 笔试.shenxinfu;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class t2 {
    public static void main(String[] args) {
        System.out.println(reverseWords("a b c d e f g", 5));
    }

    public static String reverseWords(String s, int i) {

        String[] sp = s.split(" ");

        ArrayDeque<String> ss1 = new ArrayDeque<>();
        ArrayList<String> strlist = new ArrayList<>();

        for (int j = 0; j < i; j++) {
            ss1.addFirst(sp[j]);
        }
        while (!ss1.isEmpty()) {
            strlist.add(ss1.pop());
        }
        for (int j = i; j < sp.length; j++) {
            ss1.addFirst(sp[j]);
        }
        while (!ss1.isEmpty()) {
            strlist.add(ss1.pop());
        }

        StringBuilder sb = new StringBuilder();
        int n = strlist.size();
        for (int j = 0; j < n; j++) {
            sb.append(strlist.get(j));
            if (j < n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
