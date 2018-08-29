package lc.google.medium;

import org.junit.Assert;

/**
 * @author zli
 * 
 *         Given an 2D board, count how many battleships are in it. The
 *         battleships are represented with 'X's, empty slots are represented
 *         with '.'s. You may assume the following rules:
 * 
 *         You receive a valid board, made of only battleships or empty slots.
 *         Battleships can only be placed horizontally or vertically. In other
 *         words, they can only be made of the shape 1xN (1 row, N columns) or
 *         Nx1 (N rows, 1 column), where N can be of any size. At least one
 *         horizontal or vertical cell separates between two battleships - there
 *         are no adjacent battleships.
 * 
 *         Follow up:
 * 
 *         Could you do it in one-pass, using only O(1) extra memory and without
 *         modifying the value of the board?
 * 
 */
public class P419BattleshipsInABoard {

	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					if ((i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X'))
						count++;
					else if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j] == 'X' && board[i][j - 1] == 'X')
						return -1;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		P419BattleshipsInABoard p = new P419BattleshipsInABoard();
		Assert.assertEquals(2, p.countBattleships(
				new char[][] { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } }));

		Assert.assertEquals(-1, p.countBattleships(
				new char[][] { { 'X', '.', '.', 'X' }, { 'X', 'X', 'X', 'X' }, { '.', '.', '.', 'X' } }));
	}
}

// X..X
// ...X
// ...X

// X...
// .X..
// .X..
// X...

// ...X
// XXXX
// ...X