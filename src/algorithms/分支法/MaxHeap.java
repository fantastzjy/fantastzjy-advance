package algorithms.q;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 装载和管理 HeapNode 对象。
 */
public class MaxHeap {
    // 堆节点容器
    private List<HeapNode> heap = new ArrayList<HeapNode>();

    public void put(HeapNode heapNode) {
        heap.add(heapNode);
    }

    public HeapNode removeMax() {
        Collections.sort(heap, new HeapComparator());
        HeapNode maxNode = null;
        if (!heap.isEmpty()) {
            maxNode = heap.get(0);
        }
        heap.remove(maxNode);
        return maxNode;
    }
}