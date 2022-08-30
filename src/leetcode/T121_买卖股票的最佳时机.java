package leetcode;

public class T121_买卖股票的最佳时机 {

    //暴力算法，时间超限
    //public int maxProfit(int[] prices) {
    //    int maxProfit = 0;
    //    //注意循环的界限 一个结束位置减1 一个开始位置加1
    //    for (int i = 0; i < prices.length - 1; i++) {
    //        for (int j = i + 1; j < prices.length; j++) {
    //            int profit = prices[j] - prices[i];
    //            if (maxProfit < profit) {
    //                maxProfit = profit;
    //            }
    //
    //        }
    //    }
    //    return maxProfit;
    //}

    //使用一边循环，减少循环次数时间复杂度，如果遍历到的数比已经记录的数还小就把这个值当做最小值，如果大于最小值就去减掉最小值在和最大收益作比较
    //最小值被替代时，找到新的最小值后，接下来获取到的收益的差值一定比才开始用的最小值大，但是之前的收益不一定比后来更小的最小值替换后获取的收益大
    //比如前面是 7-1 后面是5-0   最大收益仍然是前面的，虽然后来的最小值更小
    public int maxProfit(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;

    }

    //我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。
    //
    //因此，我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}