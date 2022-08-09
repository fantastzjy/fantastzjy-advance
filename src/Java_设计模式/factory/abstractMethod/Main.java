package Java_设计模式.factory.abstractMethod;

public class Main {
    public static void main(String[] args) {
        AbstractFactory ab = new ModernPerson();

        ab.createFood().printName();
        ab.createWeapon().shoot();
        ab.createVehicle().go();
    }
}
