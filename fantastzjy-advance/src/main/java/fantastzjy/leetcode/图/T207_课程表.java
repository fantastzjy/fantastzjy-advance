package fantastzjy.leetcode.图;

import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/course-schedule/
//题解  https://labuladong.gitee.io/algo/2/19/36/
public class T207_课程表 {


    //重点！！！总结
    //onPath与visited的区别
    //onpath是说此时遍历的路径正在走该点
    //visited是说已经遍历过这个点的了，不用再走了
    //因此只有当 onpath[] 为true时 说明形成了环   visited只是减少计算


    // 记录一次 traverse 递归经过的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录图中是否有环
    boolean hasCycle = false;

    boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //遍历图    要便利所有节点 ，因为课程不是全连接在一起的  如果只是  traverse(graph, 0);  则遍历的只是一门课程相关的
        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        //取反！！！！！
        return !hasCycle;
    }

    //遍历图
    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
        }

        //!!!!!!!这里并不是直接返回结果了，结果是在最后才判断的
        // 而是说这条路要么是已经遍历过了，要么是环已经出现了，没有必要在遍历下去了

        //用hasCircle效果才正确 如果存在另一个环，即使该路径没有环  遍历也是多余的  只要有换就结束
        //if (visited[i] || onPath[i]) {
        //    return;
        //}

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }


        // 前序遍历代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序遍历代码位置
        onPath[s] = false;
    }

    //构建图
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];

        //这里必须要一个一个赋值才可以！！！！！！！！
        //for (List<Integer> g : graph) {
        //    g = new LinkedList<>();
        //}
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            //注意方向，与代表的意义！！！
            int from = edge[1];
            int to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].add(to);
        }
        return graph;
    }
}