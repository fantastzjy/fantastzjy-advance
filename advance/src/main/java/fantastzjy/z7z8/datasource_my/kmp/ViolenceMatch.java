package fantastzjy.z7z8.datasource_my.kmp;

public class ViolenceMatch {

    public static void main(String[] args) {

        //测试暴力匹配算法
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);

    }

    // 暴力匹配算法实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0; // i索引指向s1
        int j = 0; // j索引指向s2
        while (i < s1Len && j < s2Len) {// 保证匹配时，不越界

            if (s1[i] == s2[j]) {//匹配ok
                i++;
                j++;
            } else { //没有匹配成功
                //如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)，j = 0。
                //zjy理解，上一步的成功已经将 I 增加，这次匹配失败说明I的位置匹配失败，所以从I的额下一个位置开始进行匹配，如果失败，I还从上次成功后增加的地方开始，
                i = i - (j - 1);//如果是i-j 就正好回到了开始匹配的那个位置，里面 J-1 的话 i就少减 1 i就会前进一步，从下一步开始进行匹配
                j = 0;
//                012345
//                zxcvbn
//                  cvbm
//                  0123
            }
        }

        //判断是否匹配成功，如果成功返回开始匹配成功的开始匹配时的位置
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }

}
