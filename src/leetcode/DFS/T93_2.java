package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

public class T93_2 {
    List<String> res;
    int[] segement;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        segement = new int[4];
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int segid, int segstart) {
        //basecase
        if (segid == 4) {
            if (segstart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(segement[i]);
                    //if (i < 4) {
                    if (i != 4 - 1) {
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }

        if (segstart == s.length()) {
            return;
        }
        if (s.charAt(segstart) == '0') {
            //segement[segid] = s.charAt(segstart);
            segement[segid] = 0;
            dfs(s, segid + 1, segstart + 1);
            //return;  不用返回
        }
        int add = 0;
        for (int segend = segstart; segend < s.length(); segend++) {
            //if (s.length() - segend >  (4-segid) * 3) {
            //    break;
            //}
            add = add * 10 + s.charAt(segend) - '0';
            if (add > 0 && add <= 255) {

                segement[segid] = add;
                dfs(s, segid + 1, segend + 1);
            } else {
                break;
            }
        }
    }

}