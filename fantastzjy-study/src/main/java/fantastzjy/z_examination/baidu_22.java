package fantastzjy.z_examination;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baidu_22 {

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
                    int index = str.lastIndexOf('1');

                    BigInteger res2 = new BigInteger("0");
                    for (int k = 0; k < str.length() - index; k++) {
                        res2 = res2.multiply(new BigInteger("10").add(new BigInteger("1")));
                    }

                    int res = Integer.parseInt("" + res2, 2);
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
