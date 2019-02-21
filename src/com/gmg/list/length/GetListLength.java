package com.gmg.list.length;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2019/2/18  9:30
 */
/*
 * 求单链表中结点的个数: getListLength
 */
public class GetListLength {
    public static void main(String[] args) {
        com.gmg.list.reverse.Node head = new com.gmg.list.reverse.Node(3);
        com.gmg.list.reverse.Node node1 = new com.gmg.list.reverse.Node(5);
        com.gmg.list.reverse.Node node2 = new com.gmg.list.reverse.Node(6);
        com.gmg.list.reverse.Node node3 = new com.gmg.list.reverse.Node(9);
        com.gmg.list.reverse.Node node4 = new com.gmg.list.reverse.Node(7);
        com.gmg.list.reverse.Node node5 = new com.gmg.list.reverse.Node(2);
        com.gmg.list.reverse.Node node6 = new com.gmg.list.reverse.Node(1);
        head.next = node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        int listLength = getListLength(head);
        System.out.println(listLength);
    }
    // 打印链表的方法，方便test函数
    public static void printList(com.gmg.list.reverse.Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /*
     * 求单链表中结点的个数
     * 注意检查链表是否为空。时间复杂度为O（n）
     */
    public static int getListLength(com.gmg.list.reverse.Node head) {
        // 注意头结点为空情况
        if (head == null) {
            return 0;
        }

        int len = 0;
        com.gmg.list.reverse.Node cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

}
// 建立链表结构类 val和next
class Node{
    int val;
    com.gmg.list.reverse.Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}
