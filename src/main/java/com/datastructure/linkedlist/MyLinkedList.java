package com.datastructure.linkedlist;

/**
 * 单向链表
 *
 * @author Yue
 * @date 2019/8/19
 */
public class MyLinkedList {

    private MyLinkedListNode headNode;

    /**
     * 链表长度最短为1
     */
    private int length;

    /**
     * 增加节点操作
     *
     * @param data
     */
    public void add(int data) {
        MyLinkedListNode node = new MyLinkedListNode(data);
        if (null == headNode) {
            this.headNode = node;
        } else {
            MyLinkedListNode temp = headNode;
            while (null != temp.next) {
                temp = temp.next;
            }
            temp.next = node;
        }
        length++;
    }

    /**
     * 头结点前插入数据
     *
     * @param data
     * @return
     */
    public int insertHead(int data) {
        MyLinkedListNode newHead = new MyLinkedListNode(data);
        if (null == headNode) {
            headNode = newHead;
        } else {
            newHead.next = headNode;
            headNode = newHead;
        }
        length++;
        return 1;
    }

    /**
     * 尾结点后追加数据
     *
     * @param data
     * @return
     */
    public int apendTail(int data) {
        MyLinkedListNode newTail = new MyLinkedListNode(data);
        if (null == headNode) {
            headNode = newTail;
        } else {
            MyLinkedListNode temp = headNode;
            while (null != temp.next) {
                temp = temp.next;
            }
            temp.next = newTail;
        }
        length++;
        return 1;
    }

    /**
     * 指定节点后插入数据
     *
     * @param node
     * @param data
     * @return 0失败 1成功
     */
    public int insertAfter(MyLinkedListNode node, int data) {
        if (null == node) {
            return 0;
        }
        if (null == headNode) {
            return 0;
        }
        if (!ifExist(node)) {
            return 0;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(data);
        newNode.next = node.next;
        node.next = newNode;
        length++;
        return 1;
    }

    /**
     * 指定节点前插入数据
     *
     * @param node
     * @param data
     * @return 0失败 1成功
     */
    public int insertBefore(MyLinkedListNode node, int data) {
        if (null == node) {
            return 0;
        }
        if (null == headNode) {
            return 0;
        }
        if (!ifExist(node)) {
            return 0;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(data);
        MyLinkedListNode temp = headNode;
        while (temp.next != null && temp.next != node) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return 1;
    }

    /**
     * 判断链表中是否包含数据
     *
     * @param data
     * @return
     */
    public boolean contains(int data) {
        boolean ifExist = false;
        MyLinkedListNode temp = headNode;
        while (null != temp.next) {
            if (temp.data == data) {
                ifExist = true;
            }
            temp = temp.next;
        }
        return ifExist;
    }

    /**
     * 判断链表中是否存在节点
     *
     * @param node
     * @return
     */
    public boolean ifExist(MyLinkedListNode node) {
        boolean ifExist = false;
        MyLinkedListNode temp = headNode;
        while (null != temp) {
            if (temp == node) {
                ifExist = true;
            }
            temp = temp.next;
        }
        return ifExist;
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int length() {
        return this.length;
    }

    /**
     * 根据位置查找元素
     *
     * @param index
     * @return null表示该位置没有数据
     */
    public MyLinkedListNode findByIndex(int index) {
        if (1 > index) {
            throw new RuntimeException("index不合法，需大于等于1");
        }
        if (length < index) {
            return null;
        }
        MyLinkedListNode temp = headNode;
        for (int currentIndex = 1; currentIndex <= length; currentIndex++) {
            if (currentIndex == index) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 根据元素查找位置
     *
     * @param element
     * @return null表示没有该数据不存在
     */
    public MyLinkedListNode findByElement(int element) {
        MyLinkedListNode temp = headNode;
        for (int currentIndex = 1; currentIndex <= length; currentIndex++) {
            if (temp.data == element) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 根据位置删除节点
     *
     * @param index
     * @return 0表示没有节点删除 1表示删除成功
     */
    public int deleteByIndex(int index) {
        if (1 > index) {
            throw new RuntimeException("index不合法，需大于等于1");
        }
        if (1 == index) {
            headNode = headNode.next;
        } else {
            MyLinkedListNode preNode = findByIndex(index - 1);
            if (null == preNode) {
                return 0;
            }
            if (null == preNode.next.next) {
                preNode.next = null;
            } else {
                preNode.next = preNode.next.next;
            }
        }
        length--;
        return 1;
    }

    /**
     * 根据元素删除节点
     *
     * @param element
     * @return 0表示没有节点删除 1表示删除成功
     */
    public int deleteByElement(int element) {
        MyLinkedListNode tmp = headNode;
        for (int currentIndex = 1; currentIndex <= length; currentIndex++) {
            if (headNode.data == element && currentIndex == 1) {
                headNode = headNode.next;
                break;
            } else if (tmp.next.data == element && null == tmp.next.next) {
                tmp.next = null;
                break;
            } else if (tmp.next.data == element) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
            if (null == tmp.next) {
                return 0;
            }
        }
        length--;
        return 1;
    }

    /**
     * 链表反转操作
     */
    public void reverse() {
        MyLinkedListNode currentTemp = headNode;
        MyLinkedListNode reverseTemp = null;
        while (currentTemp != null) {
            MyLinkedListNode next = currentTemp.next;
            currentTemp.next = reverseTemp;
            reverseTemp = currentTemp;
            currentTemp = next;
        }
        headNode = reverseTemp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyLinkedListNode temp = headNode;
        while (null != temp) {
            sb.append(", ").append(temp.data);
            temp = temp.next;
        }
        return sb.toString().substring(2, sb.length());
    }

}
