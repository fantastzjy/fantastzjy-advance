package fantastzjy.java_design_patterns.Adapter;


//三孔插座的标准
interface ThreeHole {
    void doSomething();
}

//三孔插座的实现
class ThreeHoleImpl implements ThreeHole {
    @Override
    public void doSomething() {
        System.out.println("使用    三孔   充电");
    }
}

//两孔插座的标准
interface TwoHole {
    void doSomething();
}

//两孔插座的实现
class TwoHoleImpl implements TwoHole {
    @Override
    public void doSomething() {
        System.out.println("使用    二孔     充电");
    }
}

//适配器：三孔 --> 二孔
class Three_Swith_Two_Adapter implements ThreeHole {

    private TwoHole twoHole;

    //此适配器 必须要有 一个二孔的插口才能工作
    public Three_Swith_Two_Adapter(TwoHole twoHole) {
        this.twoHole = twoHole;
    }

    @Override
    public void doSomething() {
        twoHole.doSomething();
    }
}

class Hotel {

    //旅馆默认是三孔的充电器
    private ThreeHole threeHole = new ThreeHoleImpl();

    //给旅馆加上适配器
    public void setSwitcher(ThreeHole threeHole) {
        this.threeHole = threeHole;
    }

    //充电
    public void charge() {
        threeHole.doSomething();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        // 找了一个旅馆住下
        Hotel hotel = new Hotel();
        // 如果你是三孔的充电器，开始充电，直接充电
        hotel.charge();

        // 如果你带的是二孔的充电器，拿出二孔的充电器，发现没法充电
        TwoHole twoHole = new TwoHoleImpl();
        // 这时候你下楼买一个  三孔  转换  二孔的适配器
        // 适配器的构造函数，说我需要一个二孔的插头插在我上面
        ThreeHole threeHole = new Three_Swith_Two_Adapter(twoHole);
        // 这个时候将适配器插在旅馆的  三孔排插上
        hotel.setSwitcher(threeHole);
        // 开始充电
        hotel.charge();
    }

    // 总结：适配器 实现三口插座接口   在接口中调用两口插座方法
    // 适配器替换 适配器替换酒店插座

}