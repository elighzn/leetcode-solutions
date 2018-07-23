package lc.easy;

import org.junit.Assert;

public class P136SingleNumber {
	public int singleNumber(int[] nums) {
		int single = 0;
		for (int i : nums) {
			single ^= i;
			System.out.println(single);
		}
		return single;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P136SingleNumber p = new P136SingleNumber();
		Assert.assertEquals(1, p.singleNumber(new int[] { 2, 2, 1 }));
		Assert.assertEquals(1, p.singleNumber(new int[] { 3, 1, 3 }));
		Assert.assertEquals(4, p.singleNumber(new int[] { 4, 1, 3, 1, 3 }));

	}

}
