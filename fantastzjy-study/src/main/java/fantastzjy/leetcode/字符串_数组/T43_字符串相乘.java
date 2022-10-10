package fantastzjy.leetcode.字符串_数组;

public class T43_字符串相乘 {

    public static void main(String[] args) {
        System.out.println(new T43_字符串相乘().multiply("99", "99"));
    }

    public String multiply(String num1, String num2) {
        //basecase ！！！！！
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // value[i] * value[j]   存放的索引位置刚好是 i+j+1    当都在最右边时 边界坐标是
        int[] temp = new int[m + n + 1];    //定义时的长度+1  则在使用时的实际长度是 数组的边界坐标是 m+n
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
        int in = 0;
        for (; temp[in] != 0; in++) ;


        //这里不用记  边界值 大不了最后在调试呗！
        while (index < m + n + 1) {
            sb.append(temp[index]);
            index++;
        }
        return sb.toString();
    }

}