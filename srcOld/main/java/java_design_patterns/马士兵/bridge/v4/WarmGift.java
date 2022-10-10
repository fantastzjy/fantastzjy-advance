package java_design_patterns.马士兵.bridge.v4;

public class WarmGift extends Gift {
    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }
}
