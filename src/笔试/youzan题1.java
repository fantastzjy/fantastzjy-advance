package 笔试;

public class youzan题1 {
    public int maxArea(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                sum = Math.max(sum, Math.min(height[j], height[i]) * (i - j));
            }
        }
        return sum;
    }
}
