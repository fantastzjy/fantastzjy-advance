package fantastzjy.leetcode.数学;

public class 字节高频题补充_36进制减法 {
    //T415_字符串相加  的拓展


    /**
     * 题目描述
     * 36进制由0-9，a-z，共36个字符表示。
     * <p>
     * 要求按照减法规则计算出任意两个36进制正整数的差，如48-2x =1b  （解释：152-105=47）
     * <p>
     * 要求：不允许使用先将36进制数字整体转为10进制，相减后再转回为36进制的做法
     */


    //思路
    //int x = i >= 0 ? getInt(a[i]) : 0：
    //    十进制大数相减时字符转整数是a[i] - '0'，36进制时需要实现单独的字符转换整数的getInt函数。
    //int y = j >= 0 ? getInt(b[j]) : 0;，与1同理。
    //int z = (x - borrow - y + 36) % 36：
    //    十进制减法时是(x - borrow - y + 10) % 10，36进制需要改成36，这应该不难理解。

    //res += getChar(z);：每一位减完的数需要转成对应的字符，36进制不能再使用('0' + z)了，需要额外实现整数转字符的getChar函数函数。

    //接下来，再实现上边所说的getInt函数和getChar函数就可以了。


    //纠结的点     只要是36以内都只占一位数
    public String reduceStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, borrow = 0;

        StringBuffer res = new StringBuffer();
        while (i > 0 || j >= 0 || borrow != 0) {
            int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            int y = j >= 0 ? getInt(num2.charAt(i)) : 0;

            //处理结果，借位之后在当前位置的结果
            int z = (x - borrow - y + 36) % 36;
            res.append(getChar(z)); //第4处

            //借位   好办法！
            borrow = x - borrow - y < 0 ? 1 : 0;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        res.reverse();

        //从前向后找到第一个不为0的数
        //删除前导0。注意：循环条件是res.size()-1是为防止"0000"的情况
        int pos;
        for (pos = 0; pos < res.length() - 1; pos++) {
            if (res.charAt(pos) != '0') break;
        }
        return res.substring(pos);

    }

    //转化为36进制
    //由于后续还需要反转，36进制是两位数
    char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    //获取值
    private int getInt(char ch) {
        if ('0' <= ch && ch <= '9')
            return ch - '0';
        else
            return ch - 'a' + 10;
    }

}
