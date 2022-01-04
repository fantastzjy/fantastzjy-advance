package z乱七八糟.datasource_my.sparseArray;

/**
 * \
 * 稀疏数组
 *
 * @create 2020-09-10-19:45
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始二维数组 11*11
        //0表示没有棋子，1表示黑子 2表示白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        chessArr1[4][6] = 1;

        //输出原始二维数组（遍历二维数组）
        System.out.println("原始数组为：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


        //将二维数组转为稀疏数组
        //1.遍历原始数组，确定有几个非零值
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }


        //创建稀疏数组    +1 是加上信息头那一行
        int sparseArr[][] = new int[sum + 1][3];
        //记得为稀疏数组赋值（初始化）
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //2.将二维数组非零值存入稀疏数组
        //count 用于记录是第几个非0数据 巧妙地利用count的值进行第几行值的记录与填入
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    //注意这里值的对应
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //打印稀疏数组
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //将稀疏数组转为原数组
        /*
		 *  1.的二维数组  先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始即可.
		 */

        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                chessArr2[i][j] = 0;
            }
        }

        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i <= count; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("原始数组为：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }

}
