package z7z8.datasource_my.kmp;

/**
 * @create 2020-09-30-9:40
 */
public class ViolenceMatch_my {
    public static void main(String[] args) {
        ViolenceMatch_my violenceMatch_my = new ViolenceMatch_my();

        System.out.println(
                violenceMatch_my.violenceMatch("硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好", "尚硅谷你尚硅你"));
    }

    public int violenceMatch(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        int len1 = char1.length;
        int len2 = char2.length;

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (char1[i] == char2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == len2) {
            return i - j;
        }

        return -1;
    }


}
