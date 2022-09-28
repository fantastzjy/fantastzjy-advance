package java_design_patterns.factory;

/*
### 工厂方法
工厂方法模式指定义一个创建对象的接口，让接口的实现类来决定创建哪一种对象，让类的实例化推迟到子类中进行。
客户端只需关心对应的工厂而无需关心创建细节，主要解决了产品扩展的问题，在简单工厂模式中如果产品种类变多，工厂的职责会越来越多，不便于维护。

**应用举例**
1、Collection 接口这个抽象工厂中定义了一个抽象的 `iterator` 工厂方法，返回一个 Iterator 类的抽象产品。
该方法通过 ArrayList 、HashMap 等具体工厂实现，返回 Itr、KeyIterator 等具体产品。

2、Spring 的 FactoryBean 接口的 `getObject` 方法。

**举例**
多个工厂和一种抽象产品。例如一个麦当劳店可以生产汉堡，一个肯德基店也可以生产汉堡。

 */
public class FactoryMethod {
    public static void main(String[] args) {

        new MCFactory();

    }
}

interface HamburgerFactory {
    Hamburger build();
}

class MCFactory implements HamburgerFactory {
    @Override
    public Hamburger build() {
        return new MCHamburger();
    }
}

class KFCFactory implements HamburgerFactory {
    @Override
    public Hamburger build() {
        return new KFCHamburger();
    }
}

interface Hamburger {
    void eat();
}

class MCHamburger implements Hamburger {
    @Override
    public void eat() {
        System.out.println("吃麦当劳汉堡");
    }
}

class KFCHamburger implements Hamburger {
    @Override
    public void eat() {
        System.out.println("吃肯德基汉堡");
    }
}