package leetcode.algorithms.分支法;

/**
 * 堆节点
 */
public class HeapNode {
    BBnode liveNode; // 活节点
    double upperProfit; // 节点价值上限
    double profit; // 节点所对应的价值
    double weight; // 节点所对应的重量
    int level; // 活节点在子集树中所处的层次序号

    // 构造方法
    public HeapNode(BBnode liveNode, double upperProfit, double profit,
                    double weight, int level) {
        this.liveNode = liveNode;
        this.upperProfit = upperProfit;
        this.profit = profit;
        this.weight = weight;
        this.level = level;
    }
}
