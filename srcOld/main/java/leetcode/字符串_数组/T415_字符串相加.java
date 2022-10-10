package leetcode.字符串_数组;

//我的想法是变成数组   答案是直接在后面续  最后来个字符串反转就可以了
public class T415_字符串相加 {
    public String addStrings(String num1, String num2) {
        //直接从字符串长度开始向前‘遍历’
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        //任何一个条件满足都可以在往后续
        //其中不满足的那个让他等于0就好了  这样就可以少很多判断
        //i和j是下标   如果坐标小于0  那就是字符串到头了  直接等于0就好了
        //             至于下面的i--  j--   就让他一直减小  没法避免
        while (i >= 0 || j >= 0 || add != 0) {

            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来!!!!!!!!   妙
        ans.reverse();
        return ans.toString();
    }
}


//  https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/