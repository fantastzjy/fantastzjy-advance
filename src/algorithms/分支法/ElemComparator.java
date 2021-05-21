package algorithms.q;

import java.util.Comparator;

/**
 * Element 对象比较器
 */
public class ElemComparator implements Comparator<Object> {
    public int compare(Object object1, Object object2) {
        Element element1 = (Element) object1;
        Element element2 = (Element) object2;
        if (element1.d < element2.d) {
            return 1;
        } else {
            return 0;
        }
    }
}
