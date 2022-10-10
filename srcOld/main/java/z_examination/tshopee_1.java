package z_examination;

public class tshopee_1 {


    public int MinOperations(String s) {
        // write code here
        int res = 0;
        char[] chs = s.toCharArray();

        for (int i = 1; i < s.length(); i++) {

            if (chs[i] == chs[i - 1]) {
                chs[i] = chs[i] == 'A' ? 'B' : 'A';
                res++;
            }
        }

        return res;
    }
}
