package Leetcode.图;

import java.util.LinkedList;
import java.util.List;

public class T797_所有可能的路径_2 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        path.addLast(i);
        if (i == graph.length - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        for (int s : graph[i]) {
            traverse(graph, s, path);
        }
        path.removeLast();

    }
}
