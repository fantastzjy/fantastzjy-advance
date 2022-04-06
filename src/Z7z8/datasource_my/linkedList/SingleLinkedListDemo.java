package z7z8.datasource_my.linkedList;

//package linkedList;

/**
 * @create 2020-05-21-18:02
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "林冲", "豹子头");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "卢俊义", "玉麒麟");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //测试按照任意顺序添加
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //测试按照顺序添加
        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero2);
        singleLinkedList.list();
        //测试修改
        singleLinkedList.update(new HeroNode(1, "小宋", "小雨~~"));
        singleLinkedList.update(new HeroNode(4, "小宋", "小雨~~"));
        System.out.println("修改完");
        singleLinkedList.list();

        //测试删除
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除之后");
        singleLinkedList.list();
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.del(3);
        System.out.println("删除之后");
        singleLinkedList.list();
    }

}


class SingleLinkedList {
    //    先定义头结点  为什么是private？？//构造器为什么不要, HeroNode next？？？？
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
        if (flag) { //flag不用在设置为false   因为每次调用添加的方法时都会创建为false
            System.out.printf("英雄%d已经存在，不能添加\n", heroNode.no);
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
//        heroNode.next=null;   新的结点本来 next 就是null

    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空\n");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) { //注意不是  temp.next == null
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void update(HeroNode newHeroNode) {
        //要先判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;  //直接等于头结点的下一个节点会比较好
        boolean flag = false;
        while (true) {
            //判断是否遍历完 遍历完时temp代表最后一个节点
            if (temp == null) {//不是 temp.next == null  要不然删不掉最后一个节点
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
            System.out.printf("已修改编号%d英雄的信息\n", newHeroNode.no);
        } else {
            System.out.printf("未找到编号%d英雄的信息\n", newHeroNode.no);
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
            System.out.printf("已删除编号%d的英雄\n", n);
        } else {
            System.out.printf("未找到编号%d的英雄\n", n);
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    //构造器为什么不要, HeroNode next？？？？
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
