import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P36ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length != 9 || board[0].length != 9)
      return false;

    Set<Character>[] setRows = initSet();
    Set<Character>[] setCols = initSet();
    Set<Character>[] setSqs = initSet();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (i == 2 && j == 2) {
          System.out.println();
        }
        if (board[i][j] != '.'
            && (setRows[i].contains(board[i][j]) || setCols[j].contains(board[i][j])
                || setSqs[getSqureIndex(i, j)].contains(board[i][j])))
          return false;
        else {
          setRows[i].add(board[i][j]);
          setCols[j].add(board[i][j]);
          setSqs[getSqureIndex(i, j)].add(board[i][j]);
        }
      }
    }
    
    

    return true;
  }

  static Set<Character>[] initSet() {
    Set<Character>[] sets = new Set[9];
    for (int i = 0; i < sets.length; i++) {
      sets[i] = new HashSet<>();
    }
    return sets;
  }

  static int getSqureIndex(int row, int col) {
    if (row < 3) {
      if (col < 3)
        return 0;
      else if (col < 6)
        return 1;
      else
        return 2;
    } else if (row < 6) {
      if (col < 3)
        return 3;
      else if (col < 6)
        return 4;
      else
        return 5;
    } else {
      if (col < 3)
        return 6;
      else if (col < 6)
        return 7;
      else
        return 8;
    }
  }

  public static void main(String[] args) {
    P36ValidSudoku p = new P36ValidSudoku();
    char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    System.out.println(p.isValidSudoku(input));

  }

}
