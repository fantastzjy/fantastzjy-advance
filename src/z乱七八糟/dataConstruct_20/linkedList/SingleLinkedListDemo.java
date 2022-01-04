package z乱七八糟.dataConstruct_20.linkedList;

/**
 * @create 2020-05-21-18:02
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "�ֳ�", "����ͷ");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "¬����", "������");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //���԰�������˳�����
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //���԰���˳�����
        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero2);
        singleLinkedList.list();
        //�����޸�
        singleLinkedList.update(new HeroNode(1, "С��", "С��~~"));
        singleLinkedList.update(new HeroNode(4, "С��", "С��~~"));
        System.out.println("�޸���");
        singleLinkedList.list();

        //����ɾ��
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("ɾ��֮��");
        singleLinkedList.list();
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.del(3);
        System.out.println("ɾ��֮��");
        singleLinkedList.list();
    }

}


class SingleLinkedList {
    //    �ȶ���ͷ���  Ϊʲô��private����//������Ϊʲô��Ҫ, HeroNode next��������
    private HeroNode head = new HeroNode(0, "", "");

    public void addByNo(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) { //flag����������Ϊfalse   ��Ϊÿ�ε�����ӵķ���ʱ���ᴴ��Ϊfalse
            System.out.printf("Ӣ��%d�Ѿ����ڣ��������\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
//        heroNode.next=null;   �µĽ�㱾�� next ����null

    }

    public void list() {
        if (head.next == null) {
            System.out.println("����Ϊ��\n");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) { //ע�ⲻ��  temp.next == null
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void update(HeroNode newHeroNode) {
        //Ҫ���ж��Ƿ�Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        HeroNode temp = head.next;  //ֱ�ӵ���ͷ������һ���ڵ��ȽϺ�
        boolean flag = false;
        while (true) {
            //�ж��Ƿ������ ������ʱtemp�������һ���ڵ�
            if (temp == null) {//���� temp.next == null  Ҫ��Ȼɾ�������һ���ڵ�
                break;
            } else if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
            System.out.printf("���޸ı��%dӢ�۵���Ϣ\n", newHeroNode.no);
        } else {
            System.out.printf("δ�ҵ����%dӢ�۵���Ϣ\n", newHeroNode.no);
        }
    }

    public void del(int n) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == n) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            System.out.printf("��ɾ�����%d��Ӣ��\n", n);
        } else {
            System.out.printf("δ�ҵ����%d��Ӣ��\n", n);
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    //������Ϊʲô��Ҫ, HeroNode next��������
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}