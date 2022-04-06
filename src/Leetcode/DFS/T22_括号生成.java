package Leetcode.DFS;

import java.util.*;

public class T22_括号生成 {
    //这个答案和下面的解析很好 拓展思路  1、 减少剩余的次数  2、以及路径用string 的不可变性 传递
    // 3、或者用stringbuilder类型的参数 删除时用 path.deleteCharAt(path.length() - 1);
    // 链接         https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/

    //下面的方法为更符合格式的dfs 如果用 arraylist的话 不管怎么调输出的格式不对
    //所以用的还是linkedlist类型的track   上面的那个连接 给出了个更好的解决办法！！！！！
    public static void main(String[] args) {
        System.out.println(new T22_括号生成().generateParenthesis(3));
        //LinkedList<String> track = new LinkedList<>();
        //ArrayList<String> track = new ArrayList<>();

        //track.add("2");
        //track.add("213");
        //System.out.println(track.toArray().toString());
        //System.out.println(Arrays.toString(new ArrayList<>(track).toArray()));

    }

    public static List<String> res = new LinkedList<String>();
    //public static List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        LinkedList<String> track = new LinkedList<>();
        //ArrayList<String> track = new ArrayList<>();
        backtrack(track, n, n);
        return res;
    }

    public void backtrack(LinkedList<String> track, int l, int r) {
        //public void backtrack(ArrayList<String> track, int l, int r) {
        //左边剩下的比右边多 不合格
        if (l > r) {
            return;
        }
        //其中一个超过n 不合格
        if (l < 0 || r < 0) {
            return;
        }

        //若相等则正好匹配完成
        if (l == 0 && r == 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> iterator = track.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
            }
            res.add(sb.toString());

            //如果用track用arraylist类型
            //res.add(track.toArray());
            return;
        }

        //做选择
        track.add("(");
        //遍历
        //只有两种情况，这里直接列举就好了
        backtrack(track, l - 1, r);
        //撤销选择
        track.removeLast();//LinkedList的方法
        //track.remove( track.size()-1);

        //做选择
        track.add(")");
        backtrack(track, l, r - 1);
        track.removeLast();//LinkedList的方法
        //track.remove( track.size()-1);
    }
}
