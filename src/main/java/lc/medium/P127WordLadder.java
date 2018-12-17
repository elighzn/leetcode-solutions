package lc.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P127WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		int N = endWord.length(), distance = 1;
		while (!q.isEmpty()) {
			final int M = q.size();
			for (int j = 0; j < M; j++) {
				String w = q.remove();
				for (int i = 0; i < N; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						StringBuilder newWord = new StringBuilder(w);
						newWord.setCharAt(i, c);
						String str = newWord.toString();
						if (wordSet.contains(str)) {
							if (endWord.equals(str))
								return distance + 1;

							wordSet.remove(str);
							q.offer(str);
						}
					}
				}
			}
			distance++;
		}
		return 0;
	}

	/*
	 * 
	 * LeetCode
	 * 
	 * Explore Problems Mock Contest Articles Discuss Store
	 * 
	 * New Playground
	 * 
	 * zli0619
	 * 
	 * Word Ladder Submission Detail 39 / 39 test cases passed. Status: Accepted
	 * Runtime: 540 ms
	 * 
	 * Submitted: 0 minutes ago Accepted Solutions Runtime Distribution 0 100 200
	 * 300 400 500 600 700 800 900 1000 1100 1200 0.00 0.25 0.50 0.75 1.00 1.25 1.50
	 * java You are here! Your runtime beats 17.56 % of java submissions. Runtime
	 * (ms) Distribution (%)
	 * 
	 * 0 100 200 300 400 500 600 700 800 900 1000 1100 1200 0.0 0.5 1.0 1.5 Zoom
	 * area by dragging across this chart Invite friends to challenge Word Ladder
	 * AddThis Sharing Buttons Share to Facebook Share to TwitterShare to
	 * Google+Share to Sina WeiboShare to More 13 Submitted Code: 0 minutes ago
	 * Language: java
	 * 
	 * Back to problem sample 16 ms submission
	 * 
	 * class Solution { // // S1: 只是从开始找到结尾,所以一个方向有可能会有很多路径是无用的 // // O(V) time +
	 * O(V) space，详见表格分析 V是建好的图里面的node个数，因为用dict直接remove点的 // // 形式，所以每个点最多被摸一次 //
	 * public int ladderLength(String beginWord, String endWord, List<String>
	 * wordList) { // if (beginWord == null || endWord == null) return 0; // if
	 * (beginWord.equals(endWord)) return 1;
	 * 
	 * // Set<String> dict = new HashSet<>(); // for (String word : wordList)
	 * dict.add(word);
	 * 
	 * // Queue<String> queue = new LinkedList<>(); // queue.offer(beginWord);
	 * 
	 * // int curLen = 1; // while (!queue.isEmpty()) { // int size = queue.size();
	 * 
	 * // while (size-- > 0) { // String curWord = queue.poll(); // List<String>
	 * nexts = convert(curWord, dict);
	 * 
	 * // for (String next : nexts) { // if (next.equals(endWord)) return curLen +
	 * 1; // queue.offer(next); // dict.remove(next); // 用remove的方式来查环去重 // } // }
	 * // curLen++; // }
	 * 
	 * // return 0; // }
	 * 
	 * // private List<String> convert(String curWord, Set<String> dict) { //
	 * List<String> nexts = new ArrayList<>(); // char[] arr =
	 * curWord.toCharArray();
	 * 
	 * // for (int i = 0; i < curWord.length(); i++) { // char curChar = arr[i]; //
	 * for (char c = 'a'; c <= 'z'; c++) {
	 * 
	 * // if (arr[i] != c) { // arr[i] = c; // String curStr = new String(arr); //
	 * if (dict.contains(curStr)) nexts.add(curStr); // arr[i] = curChar; // } // }
	 * // }
	 * 
	 * // return nexts; // }
	 * 
	 * // S2: 从两头开始找，会快很多 public int ladderLength(String beginWord, String endWord,
	 * List<String> wordList) {
	 * 
	 * HashSet<String> wordSet = new HashSet<>(); for (String word : wordList)
	 * wordSet.add(word);
	 * 
	 * if (!wordSet.contains(endWord)) return 0;
	 * 
	 * HashSet<String> beginSet = new HashSet<>(); HashSet<String> endSet = new
	 * HashSet<>(); beginSet.add(beginWord); endSet.add(endWord);
	 * 
	 * int minDis = 1; while (!beginSet.isEmpty() && !endSet.isEmpty()) {
	 * 
	 * // 从size小的那个作为开始的set if (beginSet.size() > endSet.size()) { HashSet<String>
	 * tmpQue = beginSet; beginSet = endSet; endSet = tmpQue; }
	 * 
	 * HashSet<String> nextLevel = new HashSet<String>(); // 在这个一步完成了queue.poll()的过程
	 * == 从hashset里面取出来 for (String cur: beginSet) { char cc[] = cur.toCharArray();
	 * for (int i = 0; i < cc.length; i++) { char temp = cc[i]; for (char c = 'a'; c
	 * <= 'z'; c++) { cc[i] = c; String str = String.valueOf(cc); if
	 * (endSet.contains(str)) return minDis + 1;
	 * 
	 * if (c != temp && wordSet.contains(str)) { nextLevel.add(str);
	 * wordSet.remove(str); } } cc[i] = temp; // setback } } beginSet = nextLevel;
	 * // 更新beginset minDis++; } return 0; } }
	 * 
	 * Copyright © 2018 LeetCode Contact Us | Jobs | Bug Bounty | FAQ | Terms |
	 * Privacy Policy United States
	 * 
	 */
	public static void main(String[] args) {
		P127WordLadder p = new P127WordLadder();
		System.out.println(
				p.ladderLength("hit", "cog", Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" })));
	}

}
