package lc.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {
    Trie trie = new Trie();
    Map<String, Integer> map = new HashMap<>();
    StringBuilder inputStr = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private PriorityQueue<Pair> getPQ() {
        return new PriorityQueue<Pair>(3, new Comparator<Pair>() {
            @Override
            public int compare(Pair e1, Pair e2) {
                if (e1.V != e2.V)
                    return e1.V - e2.V;

                return e2.K.compareTo(e1.K);
            }
        });
    }

    private void add(String s, int times) {
        trie.insert(s);
        map.put(s, map.getOrDefault(s, 0) + times);
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(inputStr.toString(), 1);
            inputStr = new StringBuilder();
            return Collections.emptyList();
        }

        inputStr.append(c);
        List<String> candidates = trie.search(inputStr.toString());

        PriorityQueue<Pair> pq = getPQ();
        for (String can : candidates) {
            Integer t = map.get(can);
            if (t == null)
                continue;

            pq.offer(new Pair(can, t));
            if (pq.size() > 3)
                pq.poll();
        }

        String[] ret = new String[pq.size()];
        for (int i = pq.size() - 1; i >= 0; i--)
            ret[i] = pq.poll().K;
        return Arrays.asList(ret);
    }

    public static void main(String[] args) {
        AutocompleteSystem as =
                new AutocompleteSystem(new String[] {"abc", "abbc", "a"}, new int[] {3, 3, 3});

        System.out.println(as.input('a'));
        System.out.println(as.input('b'));
        System.out.println(as.input('c'));

    }

    class Pair {
        String K;
        int V;

        public Pair(String word, int count) {
            this.K = word;
            this.V = count;
        }
    }

    class Trie {

        class TrieNode {
            public static final int N = 256;
            TrieNode[] next = new TrieNode[N];
            boolean isEnd = false;
        }

        TrieNode root = new TrieNode();

        public void insert(String word) {
            if (word == null)
                return;
            char[] a = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < a.length; i++) {
                if (node.next[a[i]] == null)
                    node.next[a[i]] = new TrieNode();
                node = node.next[a[i]];
            }
            node.isEnd = true;
        }

        public List<String> search(String prefix) {
            if (prefix == null || prefix.length() == 0)
                return Collections.emptyList();
            char[] a = prefix.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < a.length; i++) {
                if (node.next[a[i]] == null)
                    return Collections.emptyList();
                node = node.next[a[i]];
            }
            List<String> ret = new ArrayList<>();
            StringBuilder sb = new StringBuilder(prefix);
            helper(ret, sb, node);
            return ret;
        }

        private void helper(List<String> ret, StringBuilder sb, TrieNode node) {
            if (node.isEnd)
                ret.add(sb.toString());

            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    sb.append((char) i);
                    helper(ret, sb, node.next[i]);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
