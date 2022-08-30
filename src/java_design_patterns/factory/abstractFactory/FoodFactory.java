package java_design_patterns.factory.abstractFactory;

public interface FoodFactory {
    java_design_patterns.factory.factoryMethod.Hamburger buildHamburger();

    Drink buildDrink();
}


class MCFactory implements FoodFactory {
    @Override
    public java_design_patterns.factory.factoryMethod.Hamburger buildHamburger() {
        return new java_design_patterns.factory.factoryMethod.MCHamburger();
    }

    @Override
    public Drink buildDrink() {
        return new MCDrink();
    }
}

class KFCFactory implements FoodFactory {
    @Override
    public java_design_patterns.factory.factoryMethod.Hamburger buildHamburger() {
        return new java_design_patterns.factory.factoryMethod.KFCHamburger();
    }

    @Override
    public Drink buildDrink() {
        return new KFCDrink();
    }
}

interface Hamburger {
    void eat();
}

class MCHamburger implements java_design_patterns.factory.factoryMethod.Hamburger {
    @Override
    public void eat() {
        System.out.println("吃麦当劳汉堡");
    }
}

class KFCHamburger implements java_design_patterns.factory.factoryMethod.Hamburger {
    @Override
    public void eat() {
        System.out.println("吃肯德基汉堡");
    }
}

interface Drink {
    void drink();
}

class MCDrink implements Drink {
    @Override
    public void drink() {
        System.out.println("喝麦当劳饮料");
    }
}

class KFCDrink implements Drink {
    @Override
    public void drink() {
        System.out.println("喝肯德基饮料");
    }
}
