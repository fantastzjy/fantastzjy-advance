package leetcode.字符串_数组;

public class T43_字符串相乘 {
    public String multiply(String num1, String num2) {
        //basecase ！！！！！
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] temp = new int[m + n + 1];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                temp[i + j + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i > 0; i--) {
            temp[i - 1] += temp[i] / 10;
            temp[i] %= 10;
        }

        int index = temp[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        //for (int i = index; i <m+n-1 ; i++) {
        //    sb.append(temp[index]);
        //}
        while (index < m + n) {
            sb.append(temp[index]);
            index++;
        }
        return sb.toString();
    }

}