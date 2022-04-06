package Leetcode.岛屿问题;

public class T419_甲板上的战舰 {


    public int countBattleships(char[][] board) {

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[0].length; row++) {
                //实现判断该点是否为x  在判断该点的前一个和上一个
                if (board[col][row] == 'X') {

                    //如果不符合就跳过 同时count也不变化
                    if (col > 0 && board[col - 1][row] == 'X') {
                        continue;
                    }
                    if (row > 0 && board[col][row - 1] == 'X') {
                        continue;
                    }
                    //如果进项上面的判断合格就加1
                    count++;
                }
            }
        }
        return count;


    }
}
