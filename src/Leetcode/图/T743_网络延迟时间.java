package Leetcode.图;

import java.util.*;

//https://leetcode-cn.com/problems/network-delay-time/submissions/

public class T743_网络延迟时间 {


    //辅助类
    class Status {
        int id;
        int disFromStart;

        public Status(int id, int disFrom) {
            this.id = id;
            this.disFromStart = disFrom;
        }
    }

    public static void main(String[] args) {
        T743_网络延迟时间 t743_网络延迟时间 = new T743_网络延迟时间();
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        t743_网络延迟时间.networkDelayTime(times, 4, 2);


    }

    public int networkDelayTime(int[][] times, int n, int k) {

        //构造图
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph[from].add(new int[]{to, weight});
        }


        //dijkstra 遍历
        int[] distTo = dijkstra(graph, k);

        //寻找最大值
        int max = 0;
        for (int i = 1; i < distTo.length; i++) {

            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = max > distTo[i] ? max : distTo[i];
        }

        return max;
    }

    private int[] dijkstra(List<int[]>[] graph, int start) {

        //这里赋值大了导致出错
        //int[] distTo = new int[graph.length + 1];
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        Queue<Status> pq = new PriorityQueue<Status>((a, b) -> {
            return a.disFromStart - b.disFromStart;
        });

        pq.offer(new Status(start, 0));


        while (!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int currNodeId = curStatus.id;
            int currDistFromStatus = curStatus.disFromStart;

            if (currDistFromStatus > distTo[currNodeId]) {
                continue;
            }

            for (int[] neighbor : graph[currNodeId]) {
                int nextNodeId = neighbor[0];
                int distToNextNode = distTo[currNodeId] + neighbor[1];


                if (distTo[nextNodeId] > distToNextNode) {
                    distTo[nextNodeId] = distToNextNode;
                    pq.offer(new Status(nextNodeId, distToNextNode));
                }

            }

        }

        return distTo;


    }
}