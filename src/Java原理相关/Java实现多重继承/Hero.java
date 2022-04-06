package Java原理相关.Java实现多重继承;

//接口


interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}


interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {

    }
}

public class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim {
    @Override
    public void fly() {
    }

    @Override
    public void swim() {
    }

    /**
     * 对于fight()方法，继承父类的，所以不需要显示声明    ！！！！！   继承的父类和实现的接口都有该方法  但是用的缺失父类的怎么回事？
     */
}