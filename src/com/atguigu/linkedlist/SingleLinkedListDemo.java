package com.atguigu.linkedlist;

import java.io.Console;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
        //反转链表
//        System.out.println("反转单链表~~");
//		reversetList(singleLinkedList.getHead());
//		singleLinkedList.list();

        System.out.println("测试逆序打印单链表,没有改变链表本身结构");
        reversePrint(singleLinkedList.getHead());

        //加入按照编号的顺序
/*
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
*/

        //测试修改节点的代码
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
//        singleLinkedList.update(newHeroNode);
//        System.out.println("修改后的链表情况~~");
//        singleLinkedList.list();

        //删除一个节点
/*        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除后的链表情况~~");
        singleLinkedList.list();

        //测试一下 求单链表中有效节点的个数
        System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2

        //测试一下看看是否得到了倒数第K个节点
         HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println("res=" + res);*/

    }

    //使用方式2 逆序打印链表
    //方式2：利用栈这个数据结构,将各个节点压入到栈中,然后利用找的先进后出的特点,就实现了逆序打印的效果.
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈 将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //链表的所有节点压入栈中 push压入
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;//后移 这样就可以压入下一个节点
        }
        //将栈中的数据打印出来 pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());//stack的特点是：先进后出
        }
    }


    //将单链表反转
    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针 帮我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    //查询单链表中的倒数第K个节点
    /*
        思路：
        1.编写一个方法，接收head节点，同时接收一个index
        2.index 表示倒数第index个节点
        3.先把链表从头到尾遍历一下，得到链表的总的长度 getLength
        4.得到size后 我们从链表的第一个开始遍历遍历(size-index)个 就可以得到了
        5. 如果找到了，则返回该节点，否则返回nulll
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断链表是否为空
        if (head.next == null) {
            return null;//没有找到
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义一个辅助变量
        HeroNode cur = head.next; //5 // 3 - 2 = 3
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    //方法：获取到单链表的节点的个数(如果是带头结点的数组链表，需要不统计头结点)
    /**
     *
     * @param head 链表的头结点
     * @return 返回的就是有效的节点个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {//空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助变量 没统计头结点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头结点 头结点不要动
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表SingleLinkedList
    //思路 当不考虑编号顺序时
    //1. 找到当前链表最后的节点
    //2. 将最后这个节点的next 指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历--->temp
        HeroNode temp = head;
        //遍历链表找到最后
        while (true) {
            //找到链表的最后
            //例如在添加第一个元素时 因为是头结点的next是null 所以直接跳出循环
            //之后将你要添加的data添加到头结点的next属性
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后 就将tump后移
            //例如 再添加第二个属性时 因为头结点的next不为空了 所以将头结点下一个data(temp.next)赋给赋值temp 相当于让temp指向下一个元素
            //然后继续遍历 一直到temp.next为空 也就是链表的最后一个节点
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动 因此我们通过一个预指针来帮我们找到添加的位置
        //因为单链表 因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//标识添加的编号是否存在 默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no>heroNode.no) {//位置找到了
                break;
            } else if (temp.next.no == heroNode.no) {//说明添加的heroNode的编号已经存在
                flag = true;//编号存在
                break;
            }
            temp = temp.next;//后移 遍历当前的链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的信息
        //因为头结点不能动 因此我们需要一个辅助变量来遍历（预指针）
        HeroNode temp = head.next;
        boolean flag = false;//是否找到该节点
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }


    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) {//已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }


    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动 因此我们需要一个辅助变量来遍历（预指针）
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
}

//定义HeroNode 每个HeroNod对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}