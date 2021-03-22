package datasource_my.sort;

/**
 * @create 2020-10-06-13:26
 */
public class 快速排序 {
    public int[] Sort(int[] num){
        sort(num,0,num.length - 1);
        return num;
    }
    public void sort(int[] num,int le,int r){
        if(r <= le)return ;
        int j = partition(num,le,r);
        sort(num,le,j - 1);
        sort(num,j + 1,r);
    }
    public int partition(int[] num,int le,int r){
        int i = le;
        int j = r + 1;
        int v = num[le];
        while(true){
            while(num[++i] < v) if(i == r) break;
            while(num[--j] > v) if(j == le) break;
            if(i >= j) break;
            exch(num,i,j);
        }
        exch(num,le,j);
        return j;
    }
    public void exch(int[] num,int i,int j){
        int t = num[j];
        num[j]= num[i];
        num[i]= t;
    }
}
