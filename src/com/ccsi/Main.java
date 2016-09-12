package com.ccsi;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    TreeNode root=buildTree();
        transverseTree(root);
        System.out.println("=============");
        TreeNode res=revertTree2(root);
        transverseTree(res);
    }
    public static void transverseTree(TreeNode root){
        if(root==null) return;
        transverseTree(root.left);
        System.out.println(root.val);
        transverseTree(root.right);
    }
    //1.recursion
    public static TreeNode revertTree1(TreeNode root){
        if(root==null) return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        revertTree1(root.left);
        revertTree1(root.right);
        return root;
    }
    //2.loop
    public static TreeNode revertTree2(TreeNode root){
        if(root==null) return null;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pop();
            TreeNode temp=curr.left;
            curr.left=curr.right;
            curr.right=temp;
            if(curr.left!=null) stack.push(curr.left);
            if(curr.right!=null) stack.push(curr.right);
        }
        return root;
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(20);
        root.left=new TreeNode(10);
        root.right=new TreeNode(30);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(15);
        root.right.left=new TreeNode(25);
        root.right.right=new TreeNode(35);
        return root;
    }
}

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}