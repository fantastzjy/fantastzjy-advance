package dataConstruct_20.shiyan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Node head = new Node();
        Node current = head;
        Scanner in = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("������Ű��س������в�����");
            System.out.println("1.����2.���3.����4.ɾ��5.��ѯ");
            key = in.next().charAt(0);
            switch (key) {
                case '1':
                    System.out.print("�������ļ�����·����");
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(in.nextLine()));
                        String file = null;
                        while ((file = br.readLine()) != null) {
                            //b���ļ����Ϊ����
                            String[] bookInfo = file.split("\t");
                            Book tempBook = new Book(bookInfo[0], bookInfo[1],
                                    bookInfo[2], bookInfo[3], bookInfo[4],
                                    bookInfo[5], bookInfo[6], bookInfo[7]);
                            Node node = new Node();
                            node.book = tempBook;
                            current.next = node;
                            current = node;
                        }
                        br.close();
                        System.out.println("����ɹ���");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case '2':
                    Node node = head.next;
                    while (node != null) {
                        Book tempBook = node.book;
                        System.out.println(tempBook.isdn + "," + tempBook.bkname
                                + "," + tempBook.name + "," + tempBook.category + "," + tempBook.press
                                + "," + tempBook.time + "," + tempBook.price + "," + tempBook.count);
                        node = node.next;
                    }
                    break;
                case '3':
                    System.out.print("������ISDN�š�������������������š����浥λ������ʱ�䡢�۸������:���س���������");
                    Book tempBook = new Book(in.nextLine(), in.nextLine(), in.nextLine(),
                            in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
                    Node nodeNew = new Node();
                    nodeNew.book = tempBook;
                    current.next = nodeNew;
                    current = nodeNew;
                    System.out.println("ͼ����ӳɹ�");
                    break;
                case '4':
                    System.out.print("������ISDN:");
                    String sno = in.nextLine();
                    Node pre = head;
                    Node tmp = head.next;
                    while (tmp != null &&
                            !tmp.book.isdn.equals(sno)) {
                        pre = tmp;
                        tmp = tmp.next;
                    }
                    if (tmp != null) {
                        pre.next = tmp.next;
                        System.out.println("ͼ��ɾ���ɹ�");
                    }
                    break;
                case '5':
                    System.out.print("������ISDN��:");
                    String snoStr = in.nextLine();
                    Node tempNext = head.next;
                    while (tempNext != null &&
                            !tempNext.book.isdn.equals(snoStr)) {
                        tempNext = tempNext.next;
                    }
                    if (tempNext != null) {
                        Book bookB = tempNext.book;
                        System.out.println(bookB.isdn + "," + bookB.bkname
                                + "," + bookB.name + "," + bookB.category + "," + bookB.press
                                + "," + bookB.time + "," + bookB.price + "," + bookB.count);
                    }
                    break;
            }

        }
    }
}

/**
 * ����ڵ�
 */
class Node {
    Book book;
    Node next;
}

class Book {
    String isdn;
    String bkname;
    String name;
    String category;
    String press;
    String time;
    String price;
    String count;

    public Book(String isdn, String bkname, String name, String category, String press,
                String time, String price, String count) {
        super();
        this.isdn = isdn;
        this.bkname = bkname;
        this.name = name;
        this.category = category;
        this.press = press;
        this.time = time;
        this.price = price;
        this.count = count;
    }


}
