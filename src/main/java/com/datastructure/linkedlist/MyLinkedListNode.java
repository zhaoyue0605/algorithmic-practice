package com.datastructure.linkedlist;

/**
 * 单向链表节点
 *
 * @author Yue
 * @date 2019/8/19
 */
public class MyLinkedListNode {

    /**
     * 节点数据
     */
    int data;

    /**
     * 下一节点指针
     */
    MyLinkedListNode next;

    MyLinkedListNode(int data) {
        this.data = data;
        //单向链表，最后一个节点永远是null
        this.next = null;
    }

}
