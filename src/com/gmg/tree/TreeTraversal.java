package com.gmg.tree;

import java.util.Stack;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2019/2/18  12:34
 */
public class TreeTraversal {


    /**
     * 前序遍历，中序遍历，后序遍历
     *  前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     */
    public static void preorderTraversalRec(TreeNode root){
        if(root==null)
            return ;
        System.out.print(root.val+" ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }
    /**
     *  前序遍历迭代解法：用一个辅助stack，总是把右孩子放进栈
     */
    public static void preorderTraversal(TreeNode root){
        if(root==null)
            return ;
        Stack<TreeNode> stack = new Stack<TreeNode>(); // 辅助stack
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();  // 出栈栈顶元素
            System.out.print(cur.val+" ");
            // 关键点：要先压入右孩子，再压入左孩子，这样在出栈时会先打印左孩子再打印右孩子
            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);

        }
    }


    /**
     * 中序遍历递归解法
     * （1）如果二叉树为空，空操作。
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public static void inorderTraversalRec(TreeNode root){
        if(root==null)
            return;
        inorderTraversalRec(root.left);
        System.out.print(root.val+" ");
        inorderTraversalRec(root.right);

    }
    /**
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内，
     * 然后输出栈顶元素，再处理栈顶元素的右子树
     */
    public static void inorderTraversal(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack =new Stack<TreeNode>();
        TreeNode cur = root;
        while(true){
            while(cur!=null){      // 先添加一个非空节点所有的左孩子到栈
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty())
                break;

            cur = stack.pop();    // 因为此时已经没有左孩子了，所以输出栈顶元素
            System.out.print(cur.val+" ");
            cur = cur.right;       // 准备处理右子树
        }
    }



    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }
    /**
     *  后序遍历迭代解法
     */
    public static void postorderTraversal(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack =new Stack<TreeNode>();  // 第一个stack用于添加node和它的左右孩子
        Stack<TreeNode> output =new Stack<TreeNode>(); // 第二个stack用于翻转第一个stack输出

        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()){  // 确保所有元素都被翻转转移到第二个stack
            cur = stack.pop();    // 把栈顶元素添加到第二个stack
            output.push(cur);

            if(cur.left!=null)    // 把栈顶元素的左孩子和右孩子分别添加入第一个stack
                stack.push(cur.left);
            if(cur.right!=null)
                stack.push(cur.right);
        }

        while(!output.isEmpty()){    // 遍历输出第二个stack，即为后序遍历
            cur = output.pop();
            System.out.print(cur.val+" ");
        }
    }



    /*
                1
              /  \
             2    3
            / \  / \
           4  5 7   6
        */
        public static void main(String[] args){

            TreeNode root = new TreeNode(1);
            TreeNode r2 = new TreeNode(2);
            TreeNode r3 = new TreeNode(3);
            TreeNode r4 = new TreeNode(4);
            TreeNode r5 = new TreeNode(5);
            TreeNode r6 = new TreeNode(6);
            TreeNode r7 = new TreeNode(7);

            root.left = r2;
            root.right = r3;
            r2.left = r4;
            r2.right = r5;
            r3.right = r6;
            r3.left = r7;



            preorderTraversalRec(root);
            System.out.println();
            preorderTraversal(root);

            inorderTraversalRec(root);
            System.out.println();
            inorderTraversal(root);

            postorderTraversalRec(root);
            System.out.println();
            postorderTraversal(root);

        }

    }

    // 建立二叉树节点类
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }



}
