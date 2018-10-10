import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P36ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;

		Set<Integer>[] setRows = initSet();
		Set<Integer>[] setCols = initSet();
		Set<Integer>[] setSqs = initSet();

		Map<String, Integer> square = new HashMap<>();
		int squareIndex = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0 || i % 3 == 0)
					squareIndex++;

				square.put(i + "_" + j, squareIndex);
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && (setRows[i].contains(board[i][j]) || setCols[j].contains(board[i][j])
						|| setSqs[square.get("i" + "_" + j)].contains(board[i][j])))
					return false;
				else {
					setRows[i].add(Integer.valueOf(board[i][j]));
					setCols[j].add(Integer.valueOf(board[i][j]));
					setSqs[square.get("i" + "_" + j)].add(Integer.valueOf(board[i][j]));
				}
			}
		}

		return true;
	}

	static Set<Integer>[] initSet() {
		Set<Integer>[] sets = new Set[9];
		for (Set<Integer> set : sets)
			set = new HashSet<>();

		return sets;
	}

	public static void main(String[] args) {
		P36ValidSudoku p = new P36ValidSudoku();
		char[][] input = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		System.out.println(p.isValidSudoku(input));

	}

}
