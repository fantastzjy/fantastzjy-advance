package fantastzjy.Z7z8.dataConstruct_20.atguigu.tree;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        //��дһ��������ķ���
        int arr[] = {4, 6, 8, 5, 9};
        System.out.println("����ǰ=" + Arrays.toString(arr));
        // //��дһ��������ķ���
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 800000)��
//        }

//        System.out.println("����ǰ");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("����ǰ��ʱ����=" + date1Str);

        heapSort(arr);

//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("������ʱ����=" + date2Str);
//        System.out.println("��ʱ"+simpleDateFormat.format(data2-data1));
        System.out.println("�����=" + Arrays.toString(arr));
    }

    //��дһ��������ķ���
    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("������!!");

//		//�ֲ����
//		adjustHeap(arr, 1, arr.length);
//		System.out.println("��һ��" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//		
//		adjustHeap(arr, 0, arr.length);
//		System.out.println("�ڶ���" + Arrays.toString(arr)); // 9,6,8,5,4

        //����������մ���
        //���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
		
		/*
		* 2).���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ��"��"������ĩ��;
		  3).���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�
		  * ����ִ�е���+�������裬ֱ��������������
		*/

        for (int j = arr.length - 1; j > 0; j--) {
            //����
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        //System.out.println("����=" + Array
        // s.toString(arr));

    }

    //��һ������(������),������һ���󶥶�
	/*����:
		��ɽ���i��Ӧ�ķ�Ҷ�ӽ����������ɴ󶥶�
	*����int arr[]= {4,6,8,5,9};=>i=1 => adjustHeap=> �õ�{4, 9,8,5, 6}
	*��������ٴε��� adjustHeap �������i=0=>�õ�{4,9,8,5, 6}=> {9,6,8,5, 4}
	* @paramarr������������
	* @parami��ʾ��Ҷ�ӽ��������������
	* @param lenght��ʾ�Զ��ٸ�Ԫ�ؼ���������length �����𽥵ļ���
	*/

    public static void adjustHeap(int arr[], int i, int lenght) {

        int temp = arr[i];//��ȡ����ǰԪ�ص�ֵ����������ʱ����

        //��ʼ����
        //˵��
        //1. k = i * 2 + 1 k ��i�������ӽ��
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            //˵�����ӽ���ֵС�����ӽ���ֵ
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                k++; // k ָ�����ӽ��
            }
            //����ӽ����ڸ����
            if (arr[k] > temp) {
                //�ѽϴ��ֵ������ǰ���
                arr[i] = arr[k];
                i = k; //!!! i ָ��k,����ѭ���Ƚ�
            } else {
                break;//!
            }

            //��forѭ�������������Ѿ�����iΪ�������������ֵ���������(�ֲ�)

            arr[i] = temp;//��tempֵ�ŵ��������λ��
        }
    }
}
