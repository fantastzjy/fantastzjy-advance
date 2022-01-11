package leetcode.队列_栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class T20_有效的括号 {

    //先判断map中是否包含  如果包含则是有括号  不包含则是左括号 直接装入
    //若是右括号 判断栈是否为空 或 栈顶是否和他匹配    不匹配则return false   若匹配则弹出

    //如果最后栈变空则正确
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //如果包含说明是右括号 看其中是否存在左括号   注意后面是pairs.get(ch)
            if (pairs.containsKey(ch)) {
                //要保证栈中最右边的和该右括号匹配才可以
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();

                //是左括号 直接放入
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。