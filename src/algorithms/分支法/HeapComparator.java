package algorithms.q;

import java.util.Comparator;

/**
 * 堆节点比较器。
 */
public class HeapComparator implements Comparator<Object> {
    public int compare(Object object1, Object object2) {
        HeapNode heapNode1 = (HeapNode) object1;
        HeapNode heapNode2 = (HeapNode) object2;
        if (heapNode1.upperProfit < heapNode2.upperProfit) {
            return 1;
        } else {
            return 0;
        }
    }
}
