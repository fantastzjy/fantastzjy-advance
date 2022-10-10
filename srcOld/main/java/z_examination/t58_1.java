package z_examination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t58_1 {
    public int[] find(int[] arg) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arg.length; i++) {
            if (map.containsKey(arg[i])) {
                map.put(arg[i], 2);
            }
            map.put(arg[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arg.length; i++) {
            if (map.get(arg[i]) == 1) {
                list.add(arg[i]);
            }
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }

        return ints;
    }


}
