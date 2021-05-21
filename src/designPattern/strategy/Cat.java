package designPattern.strategy;

public class Cat {
     int weight;
     int height;

     public Cat(int weight, int height) {
          this.weight = weight;
          this.height = height;
     }

     @Override
     public String toString() {
          return "Cat{" +
                  "weight=" + weight +
                  ", height=" + height +
                  '}';
     }
}
