package leetcode.图;

import java.util.LinkedList;
import java.util.List;

//图的遍历

// 给你一个有 n 个节点的   有向无环图（DAG），
// 请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
public class T797_所有可能的路径 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        //因为s直接代表该节点的值，，二维数组中存的只是路径（同时也是节点的值）
        path.addLast(s);
        int n = graph.length;
        //n-1  !!!!!
        if (s == n - 1) {
            res.add(new LinkedList<>(path));
            //移除该节点！！！！！
            path.removeLast();
            return;
        }

        for (int i : graph[s]) {
            traverse(graph, i, path);
        }

        path.removeLast();

    }

}
//  https://leetcode-cn.com/problems/all-paths-from-source-to-target/
