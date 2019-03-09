package leetcode.search;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sfumato
 * 
 *         934. Shortest Bridge Medium
 * 
 *         Share In a given 2D binary array A, there are two islands. (An island is a
 *         4-directionally connected group of 1s not connected to any other 1s.)
 * 
 *         Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * 
 *         Return the smallest number of 0s that must be flipped. (It is guaranteed that the answer
 *         is at least 1.)
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: [[0,1],[1,0]] Output: 1
 * 
 * 
 *         Example 2:
 * 
 *         Input: [[0,1,0],[0,0,0],[0,0,1]] Output: 2
 * 
 * 
 *         Example 3:
 * 
 *         Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]] Output: 1
 * 
 * 
 *         Note:
 * 
 *         1 <= A.length = A[0].length <= 100 A[i][j] == 0 or A[i][j] == 1
 */
public class ShortestBridge {

    static class Solution {
        static final int[] DIRS = new int[] {0, 1, 0, -1, 0};

        public int shortestBridge(int[][] A) {
            int R = A.length, C = A[0].length;
            Deque<int[]> q = new LinkedList<>();

            search: for (int r = 0; r < R; r++)
                for (int c = 0; c < C; c++) {
                    if (A[r][c] == 1) {
                        dfs(q, A, r, c);
                        break search;
                    }
                }

            int ans = 0, size = 0;
            while ((size = q.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    int[] loc = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int r = loc[0] + DIRS[d];
                        int c = loc[1] + DIRS[d + 1];

                        if (r < 0 || c < 0 || r >= A.length || c >= A[r].length || A[r][c] == 2)
                            continue;

                        if (A[r][c] == 1)
                            return ans;

                        A[r][c] = 2;
                        q.offer(new int[] {r, c});
                    }
                }
                ans++;
            }
            return -1;
        }

        private void dfs(Deque<int[]> q, int[][] A, int r, int c) {
            if (r < 0 || c < 0 || r >= A.length || c >= A[r].length || A[r][c] != 1)
                return;
            A[r][c] = 2;
            q.offer(new int[] {r, c});
            dfs(q, A, r - 1, c);
            dfs(q, A, r + 1, c);
            dfs(q, A, r, c - 1);
            dfs(q, A, r, c + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = new int[][] {{0, 1}, {1, 0}};
        int ret = s.shortestBridge(input);
        System.out.println(ret);
    }
}
