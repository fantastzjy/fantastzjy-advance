package designPattern.observer.test;

class WakenUpEvent{

    private long time;
    private String location;
    private Child source;

    public WakenUpEvent(long time, String location, Child source) {
        super();
        this.time = time;
        this.location = location;
        this.source = source;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Child getSource() {
        return source;
    }

    public void setSource(Child source) {
        this.source = source;
    }


}

class Child implements Runnable {

    private Dad dad;

    public Child(Dad dad) {
        this.dad = dad;
    }

    public void wakeUp(){
        dad.actionToWakenUp(new WakenUpEvent(System.currentTimeMillis(), "bed", this));
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        wakeUp();
    }
}

class Dad {

    public void actionToWakenUp(WakenUpEvent e) {
        System.out.println(e.getTime());
        System.out.println(e.getLocation());
        System.out.println(e.getSource());
        System.out.println("Fedd the child");
    }

}

public class Test {

    public static void main(String[] args) {
        Dad d = new Dad();
        Child c = new Child(d);
        new Thread(c).start();
    }
}