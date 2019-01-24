package lc.easy;

import java.util.LinkedList;
import java.util.TreeMap;
import org.junit.Assert;

public class P716MaxStack {
    static class MaxStack {
        TreeMap<Node, LinkedList<Node>> map = new TreeMap<>();
        Node head, tail;

        /** initialize your data structure here. */
        public MaxStack() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public void push(int x) {
            Node node = new Node(x);

            if (!map.containsKey(node))
                map.put(node, new LinkedList<>());
            map.get(node).addLast(node);

            addNode(node);
        }

        public int pop() {
            return pop(head.next);
        }

        private int pop(Node node) {
            removeNode(node);
            LinkedList<Node> l = map.get(node);
            int len = l.size();
            if (len == 1)
                map.remove(node);
            else
                l.removeLast();

            return node.val;
        }

        public int top() {
            return head.next.val;
        }

        public int peekMax() {
            return map.lastKey().val;
        }

        public int popMax() {
            Node lastMax = map.lastEntry().getValue().peekLast();

            return pop(lastMax);
        }
    }

    static class Node implements Comparable<Node> {
        int val;
        Node prev = null, next = null;

        Node(int v) {
            val = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(val, o.val);
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        MaxStack p = new MaxStack();
        p.push(5);
        p.push(1);
        p.push(5);
        Assert.assertEquals(5, p.top());
        Assert.assertEquals(5, p.popMax());
        Assert.assertEquals(1, p.top());
        Assert.assertEquals(5, p.peekMax());
        Assert.assertEquals(1, p.pop());
        Assert.assertEquals(5, p.top());
    }
}
