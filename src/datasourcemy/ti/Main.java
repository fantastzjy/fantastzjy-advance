package datasourcemy.ti;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double nu = 0.1;
        double  w = 2;
        double  b = 3;
        double[][] nums = new double[N][2];
        for(int i = 0;i < N;i ++){
            nums[i][0] = sc.nextDouble();
            nums[i][1] = sc.nextDouble();
        }
        while (true){
            for(int i = 0;i < N;i ++){
                double x = nums[i][0];
                double y = nums[i][1];
                double ans = w * x + b;
                if(ans * y > 0.0000001){
                    if(i == N - 1) break;
                    else continue;
                }
                w = w + nu * y * x;
                b = b + nu * y;
            }
            break;
        }
        System.out.println("w = " + w + "  " + " b = " + b);
    }
}
/*
5
1 -0.5
2 1
3 -0.3
2.5 0.3
4 0.2
* */