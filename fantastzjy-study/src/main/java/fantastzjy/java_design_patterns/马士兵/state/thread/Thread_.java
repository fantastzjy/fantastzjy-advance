package fantastzjy.java_design_patterns.马士兵.state.thread;

public class Thread_ {
    ThreadState_ state;

    void move(Action input) {
        state.move(input);
    }

    void run() {
        state.run();
    }


}
