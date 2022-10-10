package z_examination;

public class t58_2 {
    public int[] subArraySum(int[] Array, int arrayLen, int subArrayLen) {

        int[] ans = new int[2];
        int sum = 0;
        for (int i = 0; i < subArrayLen; i++) {
            sum += Array[i];
        }
        ans[1] = sum;
        for (int i = subArrayLen; i < arrayLen; i++) {
            sum -= Array[i - subArrayLen];
            sum += Array[i];
            if (sum > ans[1]) {
                ans[0] = i - subArrayLen + 1;
                ans[1] = sum;
            }
        }
        return ans;

    }


}
