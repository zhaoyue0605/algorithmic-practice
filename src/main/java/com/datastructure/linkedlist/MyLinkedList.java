package com.datastructure.linkedlist;

/**
 * 单向链表
 *
 * @author Yue
 * @date 2019/8/19
 */
public class MyLinkedList {

    private MyLinkedListNode headNode = null;

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
        length += 1;
    }

    public int length() {
        return this.length;
    }

    public MyLinkedListNode findByIndex(int index) {
        if (1 > index) {
            throw new RuntimeException("index不合法，需大于等于1");
        }
        if (length < index) {
            throw new RuntimeException("index不合法，需小于链表最大长度" + length);
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
            if (temp.getData() == element) {
                return currentIndex;
            }
            temp = temp.next;
        }
        return 0;
    }

}
