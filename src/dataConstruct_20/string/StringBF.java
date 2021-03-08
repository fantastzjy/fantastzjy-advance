package dataConstruct_20.string;

/**
 * @create 2020-06-25-16:12
 */
public class StringBF {

    static int[] next = new int[100];

    public static void main(String[] args) {
        String S = "我是大明我我是小明嘿嘿嘿";
        String T = "我是小明";
        getNext(T, next);
        System.out.println(IndexOfKMP(S, T, 0));
    }

    public static int IndexOfKMP(String S, String T, int pos) {
        char[] a = S.toCharArray();
        char[] b = T.toCharArray();
        int i = 0;
        int j = 0;
        while (i < S.length() && j < T.length()) {
            if (j == -1 || a[i] == b[j]) {    //	继续比较
                i++;
                j++;
            } else {    //j后退重新匹配,i不变
                j = next[j];
            }
        }
        if (j >= T.length()){ //匹配成功
            return i - j;
        }

        else {//匹配失败
            return 0;
        }

    }

    public static void getNext(String T, int[] next) {
        char[] b = T.toCharArray();
        next[0] = -1;
        int i = 0, j = -1;
        while (i < T.length() - 1) {
            if (j == -1 || b[i] == b[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else{
                j = next[j];
            }

        }

    }
}


