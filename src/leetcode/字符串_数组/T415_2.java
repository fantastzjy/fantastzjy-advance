package leetcode.字符串_数组;

public class T415_2 {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int temp = 0;
        while (m > -1 || n > -1 || temp != 0) {
            int x = m >= 0 ? num1.charAt(m) - '0' : 0;
            int y = n >= 0 ? num2.charAt(n) - '0' : 0;

            int sum = x + y + temp;
            sb.append(sum % 10);
            temp = sum / 10;
            m--;
            n--;
        }
        sb.reverse();
        return sb.toString();

    }
}

//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/