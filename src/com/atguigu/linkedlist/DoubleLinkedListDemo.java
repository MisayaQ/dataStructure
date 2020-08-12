package com.atguigu.linkedlist;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-08-12 22:55
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //双向链表的测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头结点 头结点不要动
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表，显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动 因此我们需要一个辅助变量来遍历（预指针）
        HeroNode2 temp = head.next;
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


    //双向连表添加和单向一样
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历--->temp
        HeroNode2 temp = head;
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
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    //双向链表的按顺序添加
    public void addByOrder(HeroNode2 heroNode) {
        //因为头结点不能动 因此我们通过一个预指针来帮我们找到添加的位置
        //因为单链表 因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
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
            temp.next.pre = heroNode;
            heroNode.pre = temp;
        }
    }


    //双向链表的修改和单向链表一样
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的信息
        //因为头结点不能动 因此我们需要一个辅助变量来遍历（预指针）
        HeroNode2 temp = head.next;
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


    //从双向链表中删除一个节点
    public void del(int no) {
        HeroNode2 temp = head.next;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp == null) {//已经到链表的最后（最后节点的next）
                break;
            }
            if (temp.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //可以删除
            //temp.next = temp.next.next; 单向链表的
            temp.pre.next = temp.next;
            //这里代码有问题 如果是最后一个节点就不需要执行下面这句话 否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
}

//定义HeroNode 每个HeroNod对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点 默认为null
    public HeroNode2 pre;//指向前一个节点 默认为null

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
