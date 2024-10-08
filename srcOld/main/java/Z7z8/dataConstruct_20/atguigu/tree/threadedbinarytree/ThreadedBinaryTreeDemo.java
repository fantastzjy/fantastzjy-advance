package Z7z8.dataConstruct_20.atguigu.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建,现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试:以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10号结点的后继结点是 =" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法.
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6

    }

}

//定义ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType== 1的结点，第一个找到就是8结点
            //后面随着遍历而变化，因为当leftType==1时，说明该结点是按照线索化处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();

        }
    }

    //编写对二叉树进行中序线索化的方法

    /**
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodes(HeroNode node) {

        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }

        ////(一)先线索化左子树
        threadedNodes(node.getLeft());
        //(二)线索化当前结点[有难度]

        //处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!!!每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //(三)在线索化右子树
        threadedNodes(node.getRight());
    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            //���ֻ��һ��root���, ���������ж�root�ǲ��Ǿ���Ҫɾ�����
            if (root.getNo() == no) {
                root = null;
            } else {
                //�ݹ�ɾ��
                root.delNode(no);
            }
        } else {
            System.out.println("����������ɾ��~");
        }
    }

    //ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //ǰ�����
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //�������
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //�������
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

//�ȴ���HeroNode ���
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认null
    private HeroNode right; //默认null
    //说明
    //1.如果leftType== 0表示指向的是左子树,如果1则表示指向前驱结点
    //2.如果rightType= 0表示指向是右子树,如果1 表示指向后继结点

    private int leftType;
    private int rightType;


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    //�ݹ�ɾ�����
    //1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
    //2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
    public void delNode(int no) {

        //˼·
		/*
		 * 	1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
			2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
			3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
			4. �����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			5.  �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.

		 */
        //2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //4.���Ǿ���Ҫ�����������еݹ�ɾ��
        if (this.left != null) {
            this.left.delNode(no);
        }
        //5.��Ӧ�������������еݹ�ɾ��
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    //��дǰ������ķ���
    public void preOrder() {
        System.out.println(this); //����������
        //�ݹ���������ǰ�����
        if (this.left != null) {
            this.left.preOrder();
        }
        //�ݹ���������ǰ�����
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //�������
    public void infixOrder() {

        //�ݹ����������������
        if (this.left != null) {
            this.left.infixOrder();
        }
        //��������
        System.out.println(this);
        //�ݹ����������������
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //�������
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //ǰ���������

    /**
     * @param no ����no
     * @return ����ҵ��ͷ��ظ�Node ,���û���ҵ����� null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("����ǰ�����");
        //�Ƚϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }
        //1.���жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
        //2.�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {//˵�������������ҵ�
            return resNode;
        }
        //1.��ݹ�ǰ����ң��ҵ���㣬�򷵻أ�������жϣ�
        //2.��ǰ�Ľ������ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //�����������
    public HeroNode infixOrderSearch(int no) {
        //�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("�����������");
        //����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
        if (this.no == no) {
            return this;
        }
        //������������ҵݹ���������
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    //�����������
    public HeroNode postOrderSearch(int no) {

        //�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {//˵�����������ҵ�
            return resNode;
        }

        //���������û���ҵ��������������ݹ���к����������
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("����������");
        //�������������û���ҵ����ͱȽϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

}
