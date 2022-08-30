package leetcode.图;

//    https://leetcode-cn.com/problems/course-schedule-ii/
//题解  https://labuladong.gitee.io/algo/2/19/36/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T210_课程表_II_2 {

    List<Integer> res;

    boolean hasCircle;
    boolean[] visited, onPath;


    // 主函数
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new LinkedList();
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //构建图
        List<Integer>[] graph = buoldGraph(numCourses, prerequisites);

        //遍历图
        for (int i = 0; i < graph.length; i++) {
            traverse(graph, i);
        }

        if (hasCircle) {
            return new int[0];
        }

        Collections.reverse(res);

        int[] ans = new int[numCourses];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }


        return ans;
    }

    private void traverse(List<Integer>[] graph, int i) {

        if (onPath[i]) {
            hasCircle = true;
        }
        if (visited[i] || hasCircle) {
            return;
        }

        visited[i] = true;
        onPath[i] = true;

        for (Integer g : graph[i]) {
            traverse(graph, g);
        }

        onPath[i] = false;
        res.add(i);


    }

    private List<Integer>[] buoldGraph(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];

            graph[from].add(to);
        }


        return graph;
    }

}