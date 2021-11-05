package 笔试;

import java.util.*;

public class jd2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {

        }
    }

    List<String> res = new LinkedList<>();
    Map<Character, String> phoneMap;

    public List<String> letterCombinations(String digits) {
        //List<String> track = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }

        //Map<Integer, HashMap<Character>> nums = new HashMap<>(); 为什么这样不可以？？？
        phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        char[] chars = digits.toCharArray();
        //StringBuilder()添加一个 不用每次再new新的   也不用track
        backtrace(new StringBuilder(), chars, 0, 0);
        return res;
    }

    public void backtrace(StringBuilder track, char[] chars, int digitsStart, int letterIndex) {
        if (track.length() == chars.length) {
            res.add(track.toString());
            return;
        }

        String s = phoneMap.get(chars[digitsStart]);
        char[] charArray = s.toCharArray();

        for (int j = 0; j < s.length(); j++) {
            //做选择
            track.append(s.charAt(j));
            backtrace(track, chars, digitsStart + 1, letterIndex + 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
    //System.out.println(3512);


}
