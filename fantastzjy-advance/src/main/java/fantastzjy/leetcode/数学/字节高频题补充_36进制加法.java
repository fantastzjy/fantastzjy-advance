package fantastzjy.leetcode.数学;

public class 字节高频题补充_36进制加法 {
    //T415_字符串相加  的拓展


    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            int y = j >= 0 ? getInt(num2.charAt(i)) : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }


    private int getInt(char ch) {
        if ('0' <= ch && ch <= '9')
            return ch - '0';
        else
            return ch - 'a' + 10;
    }

}
