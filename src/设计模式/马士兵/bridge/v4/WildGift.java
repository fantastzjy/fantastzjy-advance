package 设计模式.马士兵.bridge.v4;

public class WildGift extends Gift {
    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }
}
