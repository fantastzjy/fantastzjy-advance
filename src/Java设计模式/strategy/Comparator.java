package Java设计模式.strategy;

@FunctionalInterface  //函数式接口  只有一个方法 可以不写  另外  里面可以写default方法的实现
public interface Comparator<T> {
    int compare(T o1, T o2);
}
