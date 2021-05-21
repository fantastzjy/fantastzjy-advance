package algorithms.q;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 分支界限法解 0 - 1 背包问题。
 */
public class BBKnapsack {
    double c; // 背包重量
    int n; // 物品总数
    double[] w; // 物品重量数组
    double[] p; // 物品价值数组
    double cw; // 当前重量
    double cp; // 当前价值
    int[] bestx; // 最优解
    MaxHeap maxHeap = new MaxHeap(); // 活节点优先队列

    // 计算节点所对应的节点的上界
    private double bound(int i) {
        double cleft = c - cw;
        double b = cp;
// 以物品单位重量价值递减装填剩余容量
        while (i <= n && w[i] <= cleft) {
            cleft -= w[i];
            b += p[i];
            i++;
        }
// 装填剩余容量装满背包
        if (i <= n) {
            b += p[i] / w[i] * cleft;
        }
        return b;
    }

    // 添加新的活节点到子集树和优先队列中
    private void addLiveNode(double upperProfit, double pp, double ww,
                             int level, BBnode parent, boolean leftChild) {
        BBnode b = new BBnode(parent, leftChild);
        HeapNode node = new HeapNode(b, upperProfit, pp, ww, level);
        maxHeap.put(node);
    }

    // 优先队列式分支界限法
    private double bbKnapsack() {
        BBnode enode = null;
        int i = 1;
        double bestp = 0.0;
        double up = bound(1);
        while (i != n + 1) {
            double wt = cw + w[i];
// 检查当前扩展节点的左儿子节点
            if (wt <= c) {
                if (cp + p[i] > bestp) {
                    bestp = cp + p[i];
                }
                addLiveNode(up, cp + p[i], cw + w[i], i + 1, enode, true);
            }
            up = bound(i + 1);
// 检查当前扩展节点的右儿子节点
            if (up >= bestp) {
                addLiveNode(up, cp, cw, i + 1, enode, false);
            }
            HeapNode node = maxHeap.removeMax();
            enode = node.liveNode;
            cw = node.weight;
            cp = node.profit;
            up = node.upperProfit;
            i = node.level;
        }
// 构造当前最优解
        for (int j = n; j > 0; j--) {
            bestx[j] = (enode.leftChild) ? 1 : 0;
            enode = enode.parent;
        }
        return cp;
    }

    /**
     * 将个物体依其单位重量价值从大到小排列，然后调用 bbKnapsack 完成对子集树优先队列式分支界
     * 限搜索。
     *
     * @return 最优解
     */
    public double knapsack(double[] pp, double[] ww, double cc, int[] xx) {
        c = cc;
        n = pp.length;
        Element[] q = new Element[n];
        double ws = 0.0;
        double ps = 0.0;
        for (int i = 0; i < n; i++) {
            q[i] = new Element(i + 1, pp[i] / ww[i]);
            ps += pp[i];
            ws += ww[i];
        }
        if (ws <= c) {
            for (int i = 1; i <= n; i++) {
                xx[i] = 1;
            }
            return ps;
        }
// 依单位重量价值排序
        Arrays.sort(q, new ElemComparator());
        p = new double[n + 1];
        w = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = pp[q[i - 1].id - 1];
            w[i] = ww[q[i - 1].id - 1];
        }
        cw = 0.0;
        cp = 0.0;
        bestx = new int[n + 1];
        maxHeap = new MaxHeap();
// 调用 bbKnapsack 求问题的最优解
        double maxp = bbKnapsack();
        for (int i = 1; i <= n; i++) {
            xx[q[i - 1].id - 1] = bestx[i];
        }
        return maxp;
    }

    public static void main(String arg[]) {
        String input;
        String flag;
        double capacity = 0;
        double[] pp;
        double[] ww;
        int[] xx;
        double bestP = 0.0;
        BBKnapsack bbKnapsack = new BBKnapsack();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                do {
                    System.out.println(" 请选择数字功能键： 1-- 输入数据， 2-- 退出系统 ");
                    flag = in.readLine().trim();
                } while (!(flag.equals("1") || flag.equals("2")));
                if (flag.equals("2")) {
                    break;
                }
                do {
                    System.out.println(" 请输入各物品重量， 数据之间必须以顿号间隔分开！ ");
                    input = in.readLine().trim();
                    input = in.readLine().replaceAll(" ", "");
                } while (input.equals(""));
                if (input.equals("2")) {
                    break;
                }
                String datas[] = input.split("[ 、]");
                int n1 = datas.length;
                pp = new double[n1];
                ww = new double[n1];
                for (int i = 0; i < n1; i++) {
                    ww[i] = Double.parseDouble(datas[i]);
                }
                do {
                    System.out.println(" 请输入各物品价值， 数据之间必须以顿号间隔分开！ ");
                    input = in.readLine().trim();
                    input = in.readLine().replaceAll(" ", "");
                } while (input.equals(""));
                if (input.equals("2")) {
                    break;
                }
                datas = input.split("[ 、]");
                int n2 = datas.length;
                if (n1 != n2) {
                    System.out.println(" 输入数据个数不一致，重新输入 ");
                    continue;
                }
                for (int i = 0; i < n1; i++) {
                    pp[i] = Double.parseDouble(datas[i]);
                }
                do {
                    System.out.println(" 请输入背包的容量： ");
                    input = in.readLine().trim();
                    input = in.readLine().replaceAll(" ", "");
                } while (input.equals(""));
                if (input.equals("2")) {
                    break;
                }
                xx = new int[n1];
                capacity = Double.parseDouble(input);
                bestP = bbKnapsack.knapsack(pp, ww, capacity, xx);
                System.out.println(" 分支界限法法解得最优价值： " + bestP);
                System.out.println(" 各个被装入物品情况 (1 表示被装入， 0表示未被装入 ) ：");
                for (int i = 0; i < n1; i++) {
                    System.out.print(xx[i] + " ");
                }
                System.out.println("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
