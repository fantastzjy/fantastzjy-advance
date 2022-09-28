package z_examination;

public class youzan题2 {
    public int[] method1(int[] array1) {
        int len = array1.length;
        int min = array1[0];
        int max = array1[len - 1];
        int minindex = 0;
        int maxindex = len - 1;
        for (int i = 0; i < len; i++) {
            if (array1[i] <= min) {
                minindex = i;
                min = array1[i];
            } else if (array1[i] > max) {
                maxindex = i;
                max = array1[i];
            }
        }

        int temp = array1[0];
        array1[0] = array1[minindex];
        array1[minindex] = temp;

        int te = array1[len - 1];
        array1[len - 1] = array1[maxindex];
        array1[maxindex] = te;

        return array1;
    }
}
