package fantastzjy.z_examination;

import java.util.LinkedList;

public class t58_11 {
    public int[] find(int[] arg) {
        //int[] ans=new int[1];
        //for(int i=0;i<arg.length;i++){
        //    ans[0] ^=arg[i];
        //}
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < arg.length; i++) {
            if (l.contains(arg[i])) {
                l.remove(l.indexOf(arg[i]));
            } else {
                l.add(arg[i]);
            }
        }
        int[] ans = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }

        return ans;
    }
}
