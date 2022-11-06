package fantastzjy.Z7z8.dataConstruct_20.linkedList;

/**
 * @create 2020-05-22-8:20
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // ����
        System.out.println("˫������Ĳ���");
        // �ȴ����ڵ�
        HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
        HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
        HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
        HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
        HeroNode2 hero5 = new HeroNode2(5, "����", "��");
        HeroNode2 hero6 = new HeroNode2(6, "����", "��");
        HeroNode2 hero7 = new HeroNode2(7, "����", "��");
        HeroNode2 hero8 = new HeroNode2(8, "����", "��");
        // ����һ��˫������
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();


        // �޸�
        HeroNode2 newHeroNode1 = new HeroNode2(4, "����ʤ", "������");
        HeroNode2 newHeroNode2 = new HeroNode2(1, "����ʤ", "������");
        doubleLinkedList.update(newHeroNode1);
        doubleLinkedList.update(newHeroNode2);
        System.out.println("�޸ĺ���������");
        doubleLinkedList.list();
        // ɾ��
        doubleLinkedList.del(3);
        doubleLinkedList.del(4);
        doubleLinkedList.del(1);
        System.out.println("ɾ������������~~");
        doubleLinkedList.list();

        //��˳�����
        doubleLinkedList.addByNo(hero5);
        doubleLinkedList.addByNo(hero7);
        doubleLinkedList.addByNo(hero6);
        doubleLinkedList.addByNo(hero8);
        System.out.println("��˳����Ӻ�");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    //��ʼ��ͷ�ڵ�
    private HeroNode2 head = new HeroNode2(0, "", "");

    public void add(HeroNode2 newHeroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = newHeroNode2;
        newHeroNode2.pre = temp;//���治Ҫpre��ע�����ﲻ��newHeroNode2.pre=temp.pre;
    }

    public void addByNo(HeroNode2 newHeroNode2) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                flag = true;
                break;
            } else if (temp.next.no > newHeroNode2.no) {
                flag = true;
                break;
            } else if (temp.next.no == newHeroNode2.no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            if (temp.next == null) {
                newHeroNode2.pre = temp;
                temp.next = newHeroNode2;
            } else {
                newHeroNode2.pre = temp;
                temp.next.pre = newHeroNode2;
                newHeroNode2.next = temp.next;
                temp.next = newHeroNode2;
            }
        } else {
            System.out.printf("�Ѵ���%d��Ӣ��", newHeroNode2.no);
        }
    }

    public void update(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("˫������Ϊ��");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next; //һ����Ҫ������仰
        }
        if (flag) {
            temp.name = heroNode2.name;
            temp.nickName = heroNode2.nickName;
            System.out.println("���޸ĸ�Ӣ��");
        } else {
            System.out.println("δ�ҵ���Ӣ��");
        }
    }

    public void del(int n) {
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == n) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            // �������ǵĴ���������?
            // ��������һ���ڵ㣬�Ͳ���Ҫִ��������仰��������ֿ�ָ��
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("δ�ҵ����Ϊ%dӢ�ۣ�ɾ��ʧ��", n);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    //������Ϊʲô��Ҫ, HeroNode next��������
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}