package java_design_patterns.factory.abstractFactory;


public interface FoodFactory {
    Hamburger buildHamburger();

    Drink buildDrink();
}

class MCFactory implements FoodFactory {
    @Override
    public Hamburger buildHamburger() {
        return new MCHamburger();
    }

    @Override
    public Drink buildDrink() {
        return new MCDrink();
    }
}

class KFCFactory implements FoodFactory {
    @Override
    public Hamburger buildHamburger() {
        return new KFCHamburger();
    }

    @Override
    public Drink buildDrink() {
        return new KFCDrink();
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