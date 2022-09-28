package z_examination;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 便利蜂2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(str);

        str = str.replace("[", " ");
        str = str.replace("]", " ");
        str = str.replace(",", " ");


        String[] a = str.trim().split("\\s+");
        int[] ints = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ints[i] = Integer.parseInt(a[i]);
        }

        int[][] arr = new int[ints.length / 2][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = ints[i];
            arr[i][1] = ints[i + 1];
        }

        System.out.println(new 便利蜂2().minAreaRect(arr));

    }

    public static int minare(int[][] arr) {

        HashSet<Integer> p = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            p.add(50001 * arr[i][0] + arr[i][1]);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i][0] != arr[j][0] && arr[i][1] != arr[j][1])
                    if (p.contains(50001 * arr[i][0] + arr[j][1]) &&
                            p.contains(50001 * arr[j][0] + arr[i][1])) {
                        res = Math.min(res, Math.abs(arr[j][0] - arr[i][0]) * Math.abs(arr[j][1] - arr[i][1]));
                    }


            }
        }

        return res < Integer.MAX_VALUE ? res : 0;

    }

    public int minAreaRect(int[][] points) {
        Set<Integer> pointSet = new HashSet();
        for (int[] point : points)
            pointSet.add(40001 * point[0] + point[1]);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; ++i)
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
                            pointSet.contains(40001 * points[j][0] + points[i][1])) {
                        ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
                                Math.abs(points[j][1] - points[i][1]));
                    }
                }
            }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}

