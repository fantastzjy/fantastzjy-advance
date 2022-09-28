package z_examination;

import java.util.Scanner;
//在一个无序且可能包含重复数字的正整数序列A中，如果存在三个数字A间]、A[]和A[k]，它们满足i<j<k (i、j和k为三个数字在序列A中出现的位置)，且A[i]<A[j]<A[k]，则称这三个数为一个递增三元组。需要注意的是递增三元组中的三个数字不要求连续出现，例如:在正整数序列{1,2,3,4,5}中，(1,3.5)是一个满足要求的递增三元组。现在给出一个正整数序列，请你编写一个程序找出和最大的递增三元组，输出该三元组中三个数字的和。如果在序列A中不存在递增三元组则输出0。
//        输入描述
//        单组输入。第1行输入一个正整数N，表示正整数序列A中数字的个数。(N<=1000)第2行输入N个正整数，对应序列A中的N个元素。两两之间用英文空格隔开，每一个正整数均不超过10一6.
//        输出描述
//        输出和最大的递增三元组中的三个数字之和,如果在输入序列中不存在递增三元组则输出0.
//        祥例输入
//        6
//        2 3 5 3 64
//        样例输出
//        14

public class 金山云_递增三元 {
//8
//
//        2 1 3 4 5 6 8 7
//        4
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] ints = new int[n];
    for (int i = 0; i < n; i++) {
        ints[i] = sc.nextInt();
    }
    System.out.println(fin(ints));
}

    public static int fin(int[] arr) {
        int len = arr.length;
        int max = 0;
        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[i]) {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if (arr[k] < arr[j]) {
                        continue;
                    }

                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum > max) {
                        max = sum;
                    }
                }

            }
        }
        return max;

    }

}
