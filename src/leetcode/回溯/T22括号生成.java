package leetcode.回溯;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class T22括号生成 {
    public static void main(String[] args) {
        System.out.println(new T22括号生成().generateParenthesis(3));
    }

    public static List<String> res = new LinkedList<String>();

    public List<String> generateParenthesis(int n) {
        LinkedList<String> track = new LinkedList<>();
        backtrack(track, n, n);
        return res;
    }

    public void backtrack(LinkedList<String> track, int l, int r) {
        if (l > r) {
            return;
        }
        if (l < 0 || r < 0) {
            return;
        }
        if (l == 0 && r == 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> iterator = track.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
            }
            res.add(sb.toString());
            return;
        }

        //做选择
        track.add("(");
        //遍历
        //只有两种情况，这里直接列举就好了
        backtrack(track, l - 1, r);
        //撤销选择
        track.removeLast();//LinkedList的方法

        //做选择
        track.add(")");
        backtrack(track, l, r - 1);
        track.removeLast();//LinkedList的方法
    }


}
