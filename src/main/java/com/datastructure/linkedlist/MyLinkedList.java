package com.datastructure.linkedlist;

/**
 * 单向链表
 *
 * @author Yue
 * @date 2019/8/19
 */
public class MyLinkedList {

    private MyLinkedListNode headNode = null;

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
        return 0;
    }

}
