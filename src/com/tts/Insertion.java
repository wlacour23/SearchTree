package com.tts;

import java.util.*;
import java.io.*;
public class Insertion {


    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Solution {

        public static void preOrder( Node root ) {

            if( root == null)
                return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

        }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

        public static Node insert(Node root,int data) {
            Node newNode = new Node(data);

            if (root == null) {
                return newNode;
            }

            Node parent = null;
            Node current = root;
            boolean isLeft = false;
            while(current != null) {
                if (current.data < data) {
                    parent = current;
                    current = current.right;
                    isLeft = false;
                } else {
                    parent = current;
                    current = current.left;
                    isLeft = true;
                }
            }

            if (isLeft) parent.left = newNode;
            else parent.right = newNode;

            return root;

        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            Node root = null;
            while(t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            scan.close();
            preOrder(root);
        }
    }
}
