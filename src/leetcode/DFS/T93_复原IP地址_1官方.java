package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

public class T93_复原IP地址_1官方 {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    //参数 ：段id 开始位置！！！
    //几种情况：segid=4 且达到字符串长度 -添加    没达到segid=4 但达到字符串长度 -剪枝 当前数字为0 -继续dfs     继续dfs
    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案  下面两个if作用
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        //判断结束的条件其实是当前数在 0-255 中间
        int addr = 0;  //必须每轮都初始化为0
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            //顺便如果首数字=0 就直接结束循环了  在上面=0的判断中dfs后直接return就可没变哟在进入这里
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                //这里不用做撤销， 因为ip地址每一位都需要
                // 如果不正确了继续做for循环增加位数   这里的撤销选择实际上就是覆盖segment的segEnd位置
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}