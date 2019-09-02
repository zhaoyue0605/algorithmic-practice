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
        length ++;
    }

    public int length() {
        return this.length;
    }

    public MyLinkedListNode findByIndex(int index) {
        if (1 > index) {
            throw new RuntimeException("index不合法，需大于等于1");
        }
        if (length < index) {
            return null;
        }
        MyLinkedListNode temp = headNode;
        for (int currentIndex = 1; currentIndex <= length; currentIndex ++) {
            if (currentIndex == index) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public int findIndexByElement(int element) {
        MyLinkedListNode temp = headNode;
        for (int currentIndex = 1; currentIndex <= length; currentIndex ++) {
            if (temp.data == element) {
                return currentIndex;
            }
            temp = temp.next;
        }
        return -1;
    }

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
        length --;
        return 1;
    }

    public int deleteByElement(int element) {
        MyLinkedListNode tmp = headNode;
        for (int currentIndex = 1; currentIndex <= length; currentIndex ++) {
            if (headNode.data == element && currentIndex == 1) {
                headNode = headNode.next;
                break;
            } else if (tmp.next.data == element && null == tmp.next.next) {
                tmp.next = null;
                break;
            } else if (tmp.next.data == element){
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
            if (null == tmp.next) {
                return 0;
            }
        }
        length --;
        return 1;
    }

}
