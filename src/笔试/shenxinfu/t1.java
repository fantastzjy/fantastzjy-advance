package 笔试.shenxinfu;

import java.util.ArrayList;
import java.util.List;

public class t1 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};

        System.out.println(shuffle(ints, 3));
    }

    public static int[] shuffle(int[] arr, int i) {

        List<Integer> strlist1 = new ArrayList<>();
        List<Integer> strlist2 = new ArrayList<>();
        List<Integer> strl = new ArrayList<>();

        for (int j = 0; j < i; j++) {
            strlist1.add(arr[j]);
        }
        for (int j = i; j < arr.length; j++) {
            strlist2.add(arr[j]);
        }
        int q = 0;
        while (!strlist1.isEmpty()) {
            strl.add(strlist1.get(q));
            if (q < strlist2.size()) {
                strl.add(strlist2.get(q));
            }
            q++;
        }

        int w = 0;
        int[] ints = new int[strl.size()];

        while (!strl.isEmpty()) {
            ints[w] = strlist2.get(w);
            w++;
        }

        return ints;
    }

}
