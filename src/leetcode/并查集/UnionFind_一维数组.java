package leetcode.并查集;


public class UnionFind_一维数组 {
    private int[] root = null;
    private int count = 0;

    //初始化
    public UnionFind_一维数组(int x) {
        root = new int[x];
        for (int i = 0; i < x; i++) {
            root[i] = i;
        }
    }

    // Find the root of X
    //如果相等就是祖先
    //若不相等 继续递归查找 并将返回值设置为当前祖先  直接标记为祖先  下次不用递归查找
    public int find(int x) {
        if (x == root[x]) {
            return root[x];
        }
        return root[x] = find(root[x]);
    }

    // Union two element into one root
    //如果两个元素的祖先不相等 直接让x的祖先的祖先为y
    // 这里的find方法  会把一路上路过的元素的祖先都直接改为rootX
    //然后 又把祖先rootX的祖先改为rootY！！！！！！
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
        }
    }

}