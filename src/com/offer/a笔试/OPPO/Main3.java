package com.offer.a笔试.OPPO;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层次遍历，每次比较最大宽度  Queue
 * 保存二叉树结点的下标  LinkedList
 * LinkedList 随 Queue 移除和增加
 */
public class Main3 {

    public int getMaxWidth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int maxWidth = 1;
        queue.offer(root);
        list.add(1);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int pos = list.removeFirst();
                if(node.left != null){
                    queue.offer(node.left);
                    list.add(2 * pos);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    list.add(2 * pos + 1);
                }
            }
            if(list.size() > 1){
                maxWidth = Math.max(maxWidth, list.getLast() - list.getFirst() + 1);
            }
        }
        return maxWidth;
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}


