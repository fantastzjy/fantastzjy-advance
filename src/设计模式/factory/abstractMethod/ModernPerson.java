package 设计模式.factory.abstractMethod;

public class ModernPerson extends AbstractFactory{
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
}
