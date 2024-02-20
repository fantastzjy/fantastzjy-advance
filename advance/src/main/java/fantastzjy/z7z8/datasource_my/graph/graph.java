package fantastzjy.z7z8.datasource_my.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class graph {

    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储图对应的邻接矩阵
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;


    public static void main(String[] args) {
        int n = 5;

        graph graph = new graph(n);

        //循环添加顶点
        String[] vertexs = {"A", "B", "C", "D", "E"};
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //graph.insertEdge(0, 1, 1);
        //graph.insertEdge(0, 2, 1);
        //graph.insertEdge(1, 3, 1);
        //graph.insertEdge(1, 4, 1);
        //graph.insertEdge(3, 7, 1);
        //graph.insertEdge(4, 7, 1);
        //graph.insertEdge(2, 5, 1);
        //graph.insertEdge(2, 6, 1);
        //graph.insertEdge(5, 6, 1);

        graph.showGraph();

        System.out.println("dfs搜索：");
        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]

    }

    //得到第一个邻接节点的下标W

    /**
     * @param index
     * @return 如果存在就返回下标，不存在返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    // 深度优先遍历算法步骤
    // 1)访问初始结点v,并标记结点v为已访问。
    // 2)查找结点v的第一个邻接结点w。
    // 3)若w存在则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
    // 4)若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
    // 5)查找结点v的w邻接结点的下一个邻接结点,转到步骤3。--》》说明用while循环


    //递归的过程中需要判断该节点是否被访问过，需要传入isVisited数组
    //第二个参数需要得到这个节点的下标
    private void dfs(boolean[] isVisited, int i) {
        //首先访问该节点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将节点设置为已经访问
        isVisited[i] = true;
        //查找i的第一个邻接节点
        int w = getFirstNeighbor(i);
        //这里是while 因为循环345步
        while (w != -1) {//说明有
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w节点已经被访问过
            w = getNextNeighbor(i, w);
        }

    }

    //对dfs进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的节点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //初始化
    public graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }


    public void showGraph() {
        for (int[] edge : edges) {
            //System.out.println(edge.toString());
            System.out.println(Arrays.toString(edge));
        }
    }


    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    //得到节点的权值
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {

        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;

    }

}
