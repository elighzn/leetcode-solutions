package algorithms.collection;

import java.util.Iterator;

public class BST<Item extends Comparable> {

  Node<Item> root;
  
  public void add(Item item) {
    root = add(root, item);
  }
  
  private Node<Item> add(Node<Item> node, Item item) {
    
    if (node==null) {
      node = new Node(item);
      return node;
    }
      
    
    
  }


  private static class Node<Item extends Comparable> {
    Item val;
    Node<Item> left;
    Node<Item> right;

    Node(Item item) {
      this.val = item;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }



}
