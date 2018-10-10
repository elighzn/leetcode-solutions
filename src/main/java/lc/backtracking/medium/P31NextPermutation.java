package lc.backtracking.medium;

public class P31NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
			
    }
	
	void nextPermutation(int[] nums, int i) {
		
	}

	public static void main(String[] args) {
		long a = 31 * 24 * 60 * 60;
		System.out.println(a);
		P31NextPermutation p = new P31NextPermutation();
		int[] input1 = new int[] {1, 2, 3};
		int[] input2 = new int[] {3, 2, 1};
		int[] input3 = new int[] {1, 1, 5};
		p.nextPermutation(input1);
		p.nextPermutation(input2);
		p.nextPermutation(input3);
		System.out.println(input1);
		System.out.println(input2);
		System.out.println(input3);
	}

}
