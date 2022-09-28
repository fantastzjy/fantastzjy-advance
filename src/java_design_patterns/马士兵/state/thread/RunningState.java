package java_design_patterns.马士兵.state.thread;

public class RunningState extends ThreadState_ {
    private Thread_ t;

    public RunningState(Thread_ t) {
        this.t = t;
    }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}
