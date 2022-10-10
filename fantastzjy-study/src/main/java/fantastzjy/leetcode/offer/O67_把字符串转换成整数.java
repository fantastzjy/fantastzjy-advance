package fantastzjy.leetcode.offer;

public class O67_把字符串转换成整数 {
    public static int strToInt(String str) {
        str = str.trim();
        //if (str == null || str.equals(" ")) {   不能用这个
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isfushu = (str.charAt(0) == '-');
        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                //return isfushu ? -res : res;
                //直接break
                break;
            }
            if (res > bndry || res == bndry && c > '7') {
                return !isfushu ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (c - '0');

        }

        return isfushu ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(O67_把字符串转换成整数.strToInt("-91283472332"));
    }
}
