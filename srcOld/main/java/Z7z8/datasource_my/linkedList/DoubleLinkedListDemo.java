package Z7z8.datasource_my.linkedList;

//package linkedList;

/**
 * @create 2020-05-22-8:20
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(5, "张三", "及");
        HeroNode2 hero6 = new HeroNode2(6, "李四", "玉");
        HeroNode2 hero7 = new HeroNode2(7, "王五", "智");
        HeroNode2 hero8 = new HeroNode2(8, "刘六", "豹");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();


        // 修改
        HeroNode2 newHeroNode1 = new HeroNode2(4, "公孙胜", "入云龙");
        HeroNode2 newHeroNode2 = new HeroNode2(1, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode1);
        doubleLinkedList.update(newHeroNode2);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();
        // 删除
        doubleLinkedList.del(3);
        doubleLinkedList.del(4);
        doubleLinkedList.del(1);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();

        //按顺序添加
        doubleLinkedList.addByNo(hero5);
        doubleLinkedList.addByNo(hero7);
        doubleLinkedList.addByNo(hero6);
        doubleLinkedList.addByNo(hero8);
        System.out.println("按顺序添加后");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    //初始化头节点
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
        newHeroNode2.pre = temp;//后面不要pre，注意这里不是newHeroNode2.pre=temp.pre;
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
            System.out.printf("已存编号%d的英雄", newHeroNode2.no);
        }
    }

    public void update(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("双向链表为空");
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
            temp = temp.next; //一定不要忘了这句话
        }
        if (flag) {
            temp.name = heroNode2.name;
            temp.nickName = heroNode2.nickName;
            System.out.println("已修改该英雄");
        } else {
            System.out.println("未找到该英雄");
        }
    }

    public void del(int n) {
        if (head.next == null) {
            System.out.println("链表为空");
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
            // 这里我们的代码有问题?
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("未找到编号为%d英雄，删除失败", n);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
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

    //构造器为什么不要, HeroNode next？？？？
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