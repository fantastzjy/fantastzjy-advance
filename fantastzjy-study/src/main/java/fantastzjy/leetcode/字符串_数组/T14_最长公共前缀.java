package fantastzjy.leetcode.字符串_数组;

public class T14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        //注意数组判断是否有效要判断是否为空和长度
        if (strs == null || strs.length == 0) {
            return "";
        }

        //才开始不用在二维数组中找到最短的一位数组  只需每次判断会否越界即可

        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            //注意这里前面是strs[0]不是strs[i]
            char str = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //注意前面是i的长度不是用j去比较      后面是strs[j].charAt(i)    第i个字符
                if (i == strs[j].length() || strs[j].charAt(i) != str) {
                    return strs[0].substring(0, i);  //注意边界！！！
                }
            }
        }

        return strs[0];
    }

}
