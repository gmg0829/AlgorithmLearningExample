package com.gmg.list.reverse;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2019/2/18  9:32
 */
/*
 * 单链表反转：遍历和递归
 */
public class ReverseNode {
    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        Node node3 = new Node(9);
        Node node4 = new Node(7);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        head.next = node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        printList(head);
//        printList(reverseNode(head));
        printList(reverseNodeRec(head));

    }
    // 打印链表的方法，方便test函数
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /*
     *  翻转链表（遍历）
     *  从头到尾遍历原链表，每遍历一个结点，
     *  将其摘下放在新链表的最前端。
     *  注意链表为空和只有一个结点的情况。时间复杂度为O（n）
     */
    public static Node reverseNode(Node head){
        // 如果链表为空或只有一个节点，无需反转，直接返回原链表表头
        if(head == null || head.next == null)
            return head;

        Node reHead = null;
        Node cur = head;
        while(cur!=null){
            Node reCur = cur;      // 用reCur保存住对要处理节点的引用
            cur = cur.next;        // cur更新到下一个节点
            reCur.next = reHead;   // 更新要处理节点的next引用
            reHead = reCur;        // reHead指向要处理节点的前一个节点
        }
        return reHead;
    }

    // 翻转递归（递归）
    // 递归的精髓在于你就默认reverseListRec已经成功帮你解决了子问题了！但别去想如何解决的
    // 现在只要处理当前node和子问题之间的关系。最后就能圆满解决整个问题。
    /*
         head
            1 -> 2 -> 3 -> 4

          head
            1--------------
                                |
                   4 -> 3 -> 2                            // Node reHead = reverseListRec(head.next);
               reHead      head.next

                   4 -> 3 -> 2 -> 1                    // head.next.next = head;
               reHead

                    4 -> 3 -> 2 -> 1 -> null            // head.next = null;
               reHead
     */
    public static Node reverseNodeRec(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node reHead = reverseNodeRec(head.next);
        head.next.next = head;      // 把head接在reHead串的最后一个后面
        head.next = null;               // 防止循环链表
        return reHead;
    }



}
// 建立链表结构类 val和next
class Node{

    int val;
    Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}
