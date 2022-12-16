package fantastzjy.leetcode.图;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * State 类
 * 辅助计算 到某点的距离
 */

class State {

    // 图节点的 id
    int id;
    // 从 start 节点到当前节点的距离
    int distFromStart;

    State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}

public class Dijkstra {

    //****************** 辅助方法  ***********************

    // 返回节点 from 到节点 to 之间的边的权重
    int weight(int from, int to) {
        return 1;
    }

    // 输入节点 s 返回 s 的相邻节点
    List<Integer> adj(int s) {
        return null;
    }

    //*********************  主方法   ********************

    // 输入一幅图和一个起点 start，计算 start 到其他节点的最短距离
    int[] dijkstra(int start, List<Integer>[] graph) {

        //************************  base ***********************
        // 图中节点的个数
        int V = graph.length;
        // 记录最短路径的权重，你可以理解为 dp table
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[V];
        // 求最小值，所以 dp table 初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        //************************  start ***********************

        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            //1、获取值
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            //2、判断是否有必要走下去
            if (curDistFromStart > distTo[curNodeID]) {
                // 已经有一条更短的路径到达 curNode 节点了
                continue;
            }


            //3、如果从该路径走，更新以该路径为源的当前节点的下一个节点
            // ps-- State中 curNodeID记录的是若走该路径的情况下的距离  如果短的话就更新 与 curNodeID  相连的其他的节点的距离信息
            // 将 curNode 的相邻节点装入队列
            for (int nextNodeID : adj(curNodeID)) {
                // 看看从 curNode 达到 nextNode 的距离是否会更短
                int distToNextNode = distTo[curNodeID] + weight(curNodeID, nextNodeID);
                if (distTo[nextNodeID] > distToNextNode) {
                    // 更新 dp table
                    distTo[nextNodeID] = distToNextNode;
                    // 将这个节点以及距离放入队列
                    /*
                        之前的疑惑点，，，解：并不会导致某个点不会遍历他相连的点，
                        State存的是下一个点，，之后会从其他路径走到如果走不到State记录的点该点
                        走到这里就是在遍历当前点!!!!!!
                     */
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
