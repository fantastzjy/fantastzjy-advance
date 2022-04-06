package Leetcode.字符串_数组;

public class T43_字符串相乘_labuladong_ {

    public static void main(String[] args) {
        System.out.println(new T43_字符串相乘_labuladong_().multiply("99", "99"));
    }

    public String multiply(String num1, String num2) {
        //basecase ！！！！！
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();

        int[] num = new int[m + n + 1];

        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                int mul = x * y;

                //int p1 = i + j, p2 = i + j + 1;
                //// 叠加到 res 上
                //int sum = mul + res[p2];
                //res[p2] = sum % 10;
                //res[p1] += sum / 10;


                int sum = num[i + j + 1] + mul;
                num[i + j + 1] = sum % 10;
                num[i + j] += sum / 10;
            }
        }
        int index = 0;
        for (; index < m + n && num[index] == 0; index++) ;

        StringBuilder sb = new StringBuilder();
        while (index < m + n) {
            index++;
            sb.append(num[index]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}