package com.offer.树;

import java.util.*;


class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
}

public class PreInLast {
}

class Solution {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    private List<Integer> preList = new ArrayList<>();
    private List<Integer> inList = new ArrayList<>();
    private List<Integer> postList = new ArrayList<>();
    public int[][] threeOrders (TreeNode root) {
        // write code here
        TreeNode preNode = root;
        if(preNode != null){
            Stack<TreeNode> preStack = new Stack<>();
            preStack.push(preNode);
            while(!preStack.isEmpty()){
                preNode = preStack.pop();
                preList.add(preNode.val);
                if(preNode.right != null) preStack.push(preNode.right);
                if(preNode.left != null) preStack.push(preNode.left);
            }
        }

        TreeNode inNode = root;
        if(inNode != null){
            Stack<TreeNode> inStack = new Stack<>();
            while(!inStack.isEmpty() || inNode != null){
                if(inNode != null){
                    inStack.push(inNode);
                    inNode = inNode.left;
                }else{
                    inNode = inStack.pop();
                    inList.add(inNode.val);
                    inNode = inNode.right;
                }
            }
        }

        TreeNode lastNode = root;
        if(lastNode != null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(lastNode);
            while(!s1.isEmpty()){
                lastNode = s1.pop();
                s2.push(lastNode);
                if(lastNode.left != null) s1.push(lastNode.left);
                if(lastNode.right != null) s1.push(lastNode.right);
            }
            while(!s2.isEmpty()){
                postList.add(s2.pop().val);
            }
        }


        //preorder(root);
        //inorder(root);
        //postorder(root);
        int n = 3, m = preList.size();
        int[][] res = new int[n][m];
        for(int i = 0; i < m; i++) res[0][i] = preList.get(i);
        for(int i = 0; i < m; i++) res[1][i] = inList.get(i);
        for(int i = 0; i < m; i++) res[2][i] = postList.get(i);
        return res;
    }

    void preorder(TreeNode root){
        if(root == null) return;
        preList.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inList.add(root.val);
        inorder(root.right);
    }

    void postorder(TreeNode root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        postList.add(root.val);
    }
}

