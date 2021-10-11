// Program to find the longest route in a Binary Tree
package com.mycompany.labsession11oct2021;

import java.util.ArrayList;

public class LongestPath {
    
    // defining a node of the binary tree
    static class Node{
        Node left;
        Node right;
        int data;
    }
    
    // Function to create a node
    static Node newNode(int data){
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.data = data;
        return temp;
    }
    
    // Function to create the longest path
    
    public static ArrayList<Integer> findLongestPath(Node root){
        // check if root is null, if null there is no binary tree
        if (root== null){
            ArrayList<Integer> result = new ArrayList<Integer>();
            return result;
        } 
        
        // Recursively call on the right Node
        ArrayList<Integer> rightNodeList= findLongestPath(root.right);
        
         // Recursively call on  left Node 
        ArrayList<Integer> leftNodeList = findLongestPath(root.left);
        
        // Insert the current node by comparing the size of the two ArrayList
        if(rightNodeList.size() > leftNodeList.size())
            rightNodeList.add(root.data);
        else
            leftNodeList.add(root.data);
        
        // return the largest ArrayList based on the size
        if (leftNodeList.size()>rightNodeList.size())
            return leftNodeList;
        else
            return rightNodeList;
    
    }
            
    
    public static void main(String args[]) {
        Node root = newNode(100);
        root.left =newNode(20);
        root.right =newNode(130);
        root.left.left= newNode(10);
        root.left.right= newNode(50);
        root.right.left= newNode(110);
        root.right.right= newNode(140);
        root.left.left.left= newNode(5);
      
        ArrayList<Integer> resultList = findLongestPath(root);
        
        int resultListSize = resultList.size();
        // First display the root
        System.out.print(resultList.get(resultListSize-1));
        
        // Then display the rest of the elements
        
        for(int i=resultListSize-2; i>=0; i--){
            System.out.print("->" + resultList.get(i));
        }
        
    }
}
