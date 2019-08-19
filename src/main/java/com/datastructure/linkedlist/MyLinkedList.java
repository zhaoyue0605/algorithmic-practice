package com.datastructure.linkedlist;

/**
 * 单向链表
 *
 * @author Yue
 * @date 2019/8/19
 */
public class MyLinkedList {

    MyLinkedListNode headNode = null;

    int length;

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

}
