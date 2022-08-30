package java_design_patterns.factory;

/**
 * 抽象工厂
 */
public abstract class AbstractFactory {
    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();
}

abstract class Weapon {
    abstract void shoot();
}

abstract class Vehicle {
    abstract void go();
}

abstract class Food {
    abstract void printName();
}

class AK47 extends Weapon {
    @Override
    void shoot() {
        System.out.println("ak47 -->");
    }
}

class car extends Vehicle {
    @Override
    void go() {
        System.out.println("car -->");
    }
}

class Bread extends Food {
    @Override
    void printName() {
        System.out.println("bread -->");
    }
}

class ModernPerson extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    public static void main(String[] args) {
        AbstractFactory ab = new ModernPerson();

        ab.createFood().printName();
        ab.createWeapon().shoot();
        ab.createVehicle().go();
    }
}