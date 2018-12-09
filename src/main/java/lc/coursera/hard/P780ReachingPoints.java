package lc.coursera.hard;

import org.junit.Assert;

/**
 * @author zhengli
 * 
 *         A move consists of taking a point (x, y) and transforming it to
 *         either (x, x+y) or (x+y, y).
 * 
 *         Given a starting point (sx, sy) and a target point (tx, ty), return
 *         True if and only if a sequence of moves exists to transform the point
 *         (sx, sy) to (tx, ty). Otherwise, return False.
 * 
 * 
 *         Examples:
 * 
 *         Input: sx = 1, sy = 1, tx = 3, ty = 5
 * 
 *         Output: True
 * 
 *         Explanation: One series of moves that transforms the starting point
 *         to the target is: (1, 1) -> (1, 2) (1, 2) -> (3, 2) (3, 2) -> (3, 5)
 * 
 * 
 *         Input: sx = 1, sy = 1, tx = 2, ty = 2
 * 
 *         Output: False
 * 
 * 
 *         Input: sx = 1, sy = 1, tx = 1, ty = 1
 * 
 *         Output: True
 * 
 *         Note:
 * 
 *         sx, sy, tx, ty will all be integers in the range [1, 10^9].
 *         
 *         
 *         						      (1,1)
 *         				  (1,2),                 (2,1)
 *         			(1,3),		(3,2),		(2,3),	   (3,1)
 *        		 (1,4),(4,3),(3,5),(5,2),(2,5),(5,3),(3,4),(4,1)
 *         
 *         (1,2)
 *         (1,3),(3,2)
 *         (1,4),(4,3),(3,5),(5,2)
 *         (1,5),(5,4),(4,7),(7,3),(3,8),(8,5),(5,7),(7,2)
 *         
 */
public class P780ReachingPoints {

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		
		if (sx == tx && sy == ty)
			return true;

		if (sx > tx || sy > ty) 
			return false;
		
		boolean fx = false, fy=false;
		
	}

	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.pow(10, 9));
		
		P780ReachingPoints p = new P780ReachingPoints();
		Assert.assertEquals(true, p.reachingPoints(1, 1, 3, 5));
		Assert.assertEquals(false, p.reachingPoints(1, 1, 2, 2));
		int a = (int) Math.pow(10, 9);
//		Assert.assertEquals(true, p.reachingPoints(1, 1, a, a));

		System.out.println("end");
	}

}
