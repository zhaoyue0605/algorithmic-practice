package com.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单向链表测试类
 *
 * @author Yue
 * @date 2019/8/19
 */
public class MyLinkedListTest {

    private static final Logger logger = LoggerFactory.getLogger(MyLinkedListTest.class);

    @Test
    public void linkedListAddTest() {
        MyLinkedList linkedList = new MyLinkedList();
        Assert.assertEquals("初始化长度应为0", 0, linkedList.length());
        linkedList.add(5);
        Assert.assertEquals("添加一个节点后长度应为1", 1, linkedList.length());
        MyLinkedListNode headNode = linkedList.findByIndex(1);
        Assert.assertEquals("根据index获取第一个元素数据应为5", 5, headNode.getData());
        Assert.assertEquals("根据index获取第一个元素数据下一节点指针应为null", null, headNode.getNext());
        logger.info("测试通过");
    }

}