package Java_原理相关;

public class Test {


    private static Test test = new Test();
    private static int value1;
    private static int value2 = 3;


    private Test() {
        value1++;
        value2++;
    }

    public static void main(String[] args) {
        System.out.println(test.value1);
        System.out.println(test.value2);


    }


}
