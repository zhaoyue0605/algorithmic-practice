package com.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
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

    private static MyLinkedList myLinkedListNo1 = null;

    private static MyLinkedList myLinkedListNo2 = null;

    @Before
    public void prepareLinkedList() {
        myLinkedListNo1 = new MyLinkedList();
        myLinkedListNo1.add(1);
        myLinkedListNo1.add(2);
        myLinkedListNo1.add(3);
        myLinkedListNo2 = new MyLinkedList();
        myLinkedListNo2.add(4);
        myLinkedListNo2.add(5);
        myLinkedListNo2.add(6);
    }

    /**
     * 链表增删改基础操作测试
     */
    @Test
    public void linkedListBaseOperateTest() {
        MyLinkedList linkedList = new MyLinkedList();
        Assert.assertEquals("初始化长度应为0", 0, linkedList.length());
        //链表增加数据
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals("添加三个节点后长度应为3", 3, linkedList.length());
        //根据位置查找数据
        MyLinkedListNode headNode = linkedList.findByIndex(1);
        Assert.assertEquals("根据index获取第一个元素数据应为1", 1, headNode.data);
        Assert.assertEquals("根据index获取最后一个元素数据后第三个指针应为null", null, headNode.next.next.next);
        //根据数据查找位置
        int index = linkedList.findIndexByElement(2);
        Assert.assertEquals("根据数据获取index位置应该为2", 2, index);
        //删除节点
        linkedList.deleteByIndex(1);
        Assert.assertEquals("删除一个节点后长度应为2", 2, linkedList.length());
        Assert.assertEquals("删除第一个节点后第一个节点数据应为2", 2, linkedList.findByIndex(1).data);
        //根据元素删除节点
        linkedList.deleteByElement(3);
        Assert.assertEquals("删除一个节点后长度应为1", 1, linkedList.length());
        Assert.assertEquals("删除第一个节点后第一个节点数据应为2", 2, linkedList.findByIndex(1).data);
        logger.info("测试通过");
    }

    /**
     * 链表反转测试
     */
    @Test
    public void linkedListReverseTest() {
        myLinkedListNo1.reverse();
        Assert.assertEquals("反转后第一个节点后数据应为3", 3, myLinkedListNo1.findByIndex(1).data);
        Assert.assertEquals("反转后第一个节点后数据应为2", 2, myLinkedListNo1.findByIndex(2).data);
        Assert.assertEquals("反转后第一个节点后数据应为1", 1, myLinkedListNo1.findByIndex(3).data);
        myLinkedListNo1.reverse();
        Assert.assertEquals("二次反转后第一个节点后数据应为1", 1, myLinkedListNo1.findByIndex(1).data);
        Assert.assertEquals("二次反转后第一个节点后数据应为2", 2, myLinkedListNo1.findByIndex(2).data);
        Assert.assertEquals("二次反转后第一个节点后数据应为3", 3, myLinkedListNo1.findByIndex(3).data);
        logger.info("测试通过");
    }

}
