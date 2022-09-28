package leetcode.字符串_数组;

public class T43_字符串相乘_labuladong {
    public String multiply(String num1, String num2) {
        //basecase ！！！！！
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        // 结果最多为 m + n 位数     9*9=81   2*3=6   9*99=891   所以最多m+n 位数
        int[] res = new int[m + n + 1];
        // 从个位数开始逐位相乘
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                int mul = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                // 乘积在 res 对应的索引位置
                int p1 = i + j, p2 = i + j + 1;
                // 叠加到 res 上
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        // 结果前缀可能存的 0（未使用的位）
        int i = 0;
        while (i < res.length && res[i] == 0)
            i++;
        // 将计算结果转化成字符串
        //String 没有 append()方法
        StringBuilder sb = new StringBuilder();
        for (; i < m + n; i++)
            sb.append(res[i]);

        return sb.length() == 0 ? "0" : sb.toString();
    }

}