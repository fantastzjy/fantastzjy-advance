package fantastzjy.z_examination;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baidu_2_ {
    /*
    4
1
3
5
1000
1
5
13
9120

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int num = sc.nextInt();

            for (int l = 1; l <= num; l++) {
                if (map.containsKey(l)) {
                    ints[i] = ints[i] + map.get(l);
                } else {
                    String str = Integer.toBinaryString(l);

                    //boolean have1 = false;
                    //char[] chars = str.toCharArray();
                    //
                    //for (int j = chars.length - 1; j >= 0; j--) {
                    //
                    //    if (have1 == false && chars[j] == '0') {
                    //        chars[j] = '1';
                    //    } else if (have1 == false && chars[j] == '1') {
                    //        have1 = true;
                    //    } else if (have1 == true) {
                    //        chars[j] = '0';
                    //    }
                    //}

                    //char[] chars = str.toCharArray();

                    //for (int j = str.length() - 1; j >= 0; j--) {
                    int index = str.lastIndexOf('1');
                    //String strnew =
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < str.length() - index; k++) {
                        sb.append("1");
                    }
                    //}

                    //have1 = false;

                    //str = String.valueOf(chars);
                    //int res = Integer.parseInt(str, 2);
                    int res = Integer.parseInt(sb.toString(), 2);
                    map.put(l, res);
                    ints[i] = ints[i] + res;
                }

            }
        }
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
