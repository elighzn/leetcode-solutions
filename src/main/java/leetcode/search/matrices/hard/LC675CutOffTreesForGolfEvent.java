package leetcode.search.matrices.hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.elio.utils.Array2DUtils;

public class LC675CutOffTreesForGolfEvent {

    static class Solution {
        private static final int[] DIR = new int[] {0, 1, 0, -1, 0};

        public int cutOffTree(List<List<Integer>> forest) {
            int ans = 0;

            final int R = forest.size(), C = forest.get(0).size();

            int[][] f = new int[R][C];
            List<int[]> trees = new LinkedList<>();
            for (int i = 0; i < R; i++) {
                List<Integer> list = forest.get(i);
                for (int j = 0; j < C; j++) {
                    int h = list.get(j);
                    if (h > 1)
                        trees.add(new int[] {i, j, h});
                    f[i][j] = h;
                }
            }

            Collections.sort(trees, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
            });


            int[] src = new int[] {0, 0, 1};
            for (int[] next : trees) {
                int dist = bfs(f, src, next, R, C);
                if (dist == -1)
                    return -1;
                ans += dist;
                src = next;
            }
            return ans;
        }

        int bfs(int[][] f, int[] src, int[] dest, final int R, final int C) {
            boolean[][] visited = new boolean[R][C];
            Deque<int[]> q = new LinkedList<>();
            q.offer(src);
            int ret = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] curr = q.poll();
                    if (visited[curr[0]][curr[1]])
                        continue;
                    if (curr[0] == dest[0] && curr[1] == dest[1]) {
                        dest[2] = 1;
                        return ret;
                    }
                    visited[curr[0]][curr[1]] = true;
                    for (int d = 0; d < 4; d++) {
                        int r = curr[0] + DIR[d];
                        int c = curr[1] + DIR[d + 1];
                        if (r < 0 || c < 0 || r >= R || c >= C || visited[r][c])
                            continue;
                        if (f[r][c] == 0) {
                            visited[r][c] = true;
                            continue;
                        }
                        q.offer(new int[] {r, c, 2});
                    }
                }
                ret++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String input =
                "[[56617,47231,24237,22280,3005,10630,79562,90622,41623,96953,49499,22104,17942,85468,71607,80196,0,19359,57729,10524,0,16264,92606,86811,88220,50916,51862,75190,68322,68225,76182,65038,10568,99985,13666,44829,35086,8875,69000,67012],[39118,77960,38396,66408,75433,31501,76594,71328,0,72890,70316,59280,11955,0,58342,52935,56468,96413,0,0,0,65835,72685,27593,0,0,44940,80743,49690,96146,22671,35997,86551,8144,15615,44281,31649,30011,11009,98473],[17431,98660,14736,13227,99325,43277,25481,55181,73205,38327,90752,26489,26837,77293,64694,16839,0,11577,45516,94677,0,66331,87943,24759,65064,0,60642,48599,742,38053,0,93955,38154,79089,93314,26822,94919,64059,93134,0],[81575,96701,14011,31751,84906,67676,33565,44406,11000,66642,36772,93971,44369,89750,78813,99396,80249,0,22531,0,41009,64547,0,4958,68638,65300,58221,74384,15925,98842,92817,15560,85571,10938,77779,34798,0,85231,54405,6808],[46458,72404,98061,5779,54901,15010,64514,33715,0,96018,58533,12090,0,69143,64483,74090,49430,74003,37900,8960,48670,8708,42415,44604,75290,11736,86367,98527,21526,54807,37040,54407,15866,8326,29623,14570,30453,90589,60563,87278],[1148,98611,18967,47309,23697,61630,24469,0,0,56481,67253,31395,34800,30270,97478,67104,43770,7145,87219,70561,38292,35885,83475,36700,87317,99436,47376,96501,20654,58233,83624,98364,0,55811,37887,64461,91359,48140,94241,19261],[81343,23420,81010,62236,97990,8529,0,39505,5238,90359,71949,76447,17455,58571,80822,99268,90434,20548,8352,50243,47532,17441,98153,69459,54712,50091,32061,67319,24741,64162,32592,80872,84779,94065,60478,35167,63241,17204,45036,81085],[73063,21341,50047,1927,35779,87151,54520,0,4089,74814,24515,27239,37370,0,70395,29610,13331,59797,99222,35396,27207,43232,15330,0,0,81836,0,66707,2509,51487,83203,0,97001,67081,62448,48774,81933,0,15198,59436],[11917,93710,13127,57696,14604,46362,55927,31255,71865,43570,18266,39446,60802,2330,93689,9609,0,81057,51759,86188,92999,56247,4610,81084,1722,18158,31966,0,47551,8927,26448,53919,76270,41641,63218,10867,70660,55295,0,7227]]";
        
        List<List<Integer>> forest = Array2DUtils.stringToInt2dList(input);
        
        Solution s = new Solution();
        System.out.println(s.cutOffTree(forest));
    }

}
