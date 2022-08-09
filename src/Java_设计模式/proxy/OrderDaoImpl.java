package Java_设计模式.proxy;


public class OrderDaoImpl implements OrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
