package fantastzjy.leetcode.图;

import java.util.LinkedList;
import java.util.List;

public class T207_课程表_2 {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCircle;

    boolean canFinish(int numCourses, int[][] prerequisites) {

        //构建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //遍历图    要便利所有节点 ，因为课程不是全连接在一起的  如果只是  traverse(graph, 0);  则遍历的只是一门课程相关的
        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }

        //取反！！！！！
        return !hasCircle;
    }

    private void traverse(List<Integer>[] graph, int i) {

        if (onPath[i]) {
            hasCircle = true;
        }
        //用hasCircle效果才正确 如果存在另一个环，即使该路径没有环  遍历也是多余的  只要有换就结束
        //if (visited[i] || onPath[i]) {
        //    return;
        //}
        if (visited[i] || hasCircle) {
            return;
        }

        visited[i] = true;
        onPath[i] = true;

        for (Integer g : graph[i]) {
            traverse(graph, g);
        }

        onPath[i] = false;
    }


    //构建图
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new LinkedList[numCourses];
        //这里必须要一个一个赋值才可以！！！！！！！！
        //for (List<Integer> g : graph) {
        //    g = new LinkedList<>();
        //}
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }


        for (int[] prerequisite : prerequisites) {
            //注意方向，与代表的意义！！！
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }


        return graph;
    }


}