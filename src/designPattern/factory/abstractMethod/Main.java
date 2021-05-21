package designPattern.factory.abstractMethod;

public class Main {
    public static void main(String[] args) {
        AbstractFactory ab = new ModernPerson();
        ab.createFood().printName();
    }
}
