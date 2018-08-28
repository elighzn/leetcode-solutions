package lc.google.easy;
import org.junit.Assert;

public class P169MajorityElement {
	public int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}

	public static void main(String[] args) {
		P169MajorityElement p = new P169MajorityElement();
		Assert.assertEquals(3, p.majorityElement(new int[] { 3, 2, 3 }));
		Assert.assertEquals(2, p.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

}
