package leetcode.队列_栈;

import java.util.*;

public class T20_2 {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {

                if (deque.isEmpty() || deque.peek() != ch) {
                    return false;
                }
                deque.pop();
            } else {
                deque.push(ch);

            }

        }
        return deque.isEmpty();

    }
}
