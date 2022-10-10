package leetcode.BFS;

import java.util.HashSet;
import java.util.LinkedList;

public class T752打开转盘锁 {
    public static void main(String[] args) {

    }

    public int openLock(String[] deadends, String target) {
        //死亡名单
        HashSet<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (deads.contains(str)) {
                    continue;

                }
                if (target.equals(str)) {
                    return step;
                }
                //char[] chars = str.toCharArray();

                for (int j = 0; j < 4; j++) {
                    //String up = up(chars, j);  如果传进去chars 就改变了  不是一次只变一个了
                    //String down = down(chars, j);
                    String up = up(str.toCharArray(), j);
                    String down = down(str.toCharArray(), j);

                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }

                }

            }
            step++;
        }

        return -1;

    }

    public String up(char[] chars, int i) {

        if (chars[i] == '9') {
            chars[i] = '0';
        }else {
            chars[i] += 1;
        }
        return new String(chars);
    }
    public String down(char[] chars, int i) {
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

}

