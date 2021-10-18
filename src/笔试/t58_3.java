package 笔试;

public class t58_3 {
    public int getTeams(int[] heros) {

        int ans = 1;
        int[] count = new int[5];
        for (int i = 0; i < heros.length; i++) {
            count[heros[i]]++;

        }

        for (int i = 0; i < 5; i++) {
            ans *= count[i];
        }
        return ans;
    }


}
