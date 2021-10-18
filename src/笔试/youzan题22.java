package 笔试;

public class youzan题22 {
    int INF = Integer.MAX_VALUE;

    public int[] method1(int[] array1) {
        int min = INF;
        int id1 = 0;
        int max = -INF;
        int id2 = 0;

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < min) {
                min = array1[i];
                id1 = i;
            }
            if (array1[i] > max) {
                max = array1[i];
                id2 = i;
            }
        }
        int temp = array1[0];
        array1[0] = array1[id1];
        array1[id1] = temp;

        int te = array1[array1.length - 1];
        array1[array1.length - 1] = array1[id2];
        array1[id2] = te;

        return array1;
    }
}
