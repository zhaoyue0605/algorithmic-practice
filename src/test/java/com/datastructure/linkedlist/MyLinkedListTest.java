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
        MyLinkedListNode node = linkedList.findByElement(2);
        Assert.assertEquals("根据数据获取的元素中data应为2", 2, node.data);
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
     * 链表判断是否存在测试
     */
    @Test
    public void linkedListJudgeExistTest() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        boolean ifExist1 = linkedList.contains(4);
        Assert.assertTrue("数据存在，应为true",ifExist1);
        boolean ifExist2 = linkedList.contains(8);
        Assert.assertFalse("数据不存在，应为false", ifExist2);
        MyLinkedListNode node1 = linkedList.findByIndex(1);
        boolean ifExist3 = linkedList.ifExist(node1);
        Assert.assertTrue("节点存在，应为true",ifExist3);
        MyLinkedListNode newNode = new MyLinkedListNode(7);
        boolean ifExist4 = linkedList.ifExist(newNode);
        Assert.assertFalse("节点不存在，应为false",ifExist4);
        logger.info("测试通过");
    }

    /**
     * 链表增其他操作测试
     */
    @Test
    public void linkedListOtherOperateTest() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.insertHead(6);
        Assert.assertEquals("头结点新增加后新的头节点应为6", 6, linkedList.findByIndex(1).data);
        Assert.assertEquals("头结点新增加后链表长度应该为4", 4, linkedList.length());
        linkedList.apendTail(12);
        Assert.assertEquals("尾结点新增加后后尾节点应为12", 12, linkedList.findByIndex(5).data);
        Assert.assertEquals("尾结点新增加后后链表长度应该为5", 5, linkedList.length());
        linkedList.insertAfter(linkedList.findByIndex(4), 10);
        Assert.assertEquals("第4个节点后插入新节点后第5个节点应为10", 10, linkedList.findByIndex(5).data);
        Assert.assertEquals("头结点新增加一个后链表长度应该为6", 6, linkedList.length());
        linkedList.insertBefore(linkedList.findByIndex(6), 11);
        Assert.assertEquals("第4个节点后插入新节点后第6个节点应为11", 11, linkedList.findByIndex(6).data);
        Assert.assertEquals("头结点新增加一个后链表长度应该为7", 7, linkedList.length());
        System.out.println(linkedList.toString());
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
