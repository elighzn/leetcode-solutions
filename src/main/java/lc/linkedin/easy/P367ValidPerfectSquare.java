package lc.linkedin.easy;

public class P367ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num==1)
		return true;
		
		int lo = 0, hi = num;
		
		while (lo <= hi) {
			long mid = (hi + lo) >> 1;
			long sq = mid * mid;
			if (sq == num)
				return true;
			else if (sq > num)
				hi = (int)mid - 1;
			else
				lo = (int)mid + 1;
		}
    return false;
    }

	public static void main(String[] args) {
		P367ValidPerfectSquare p = new P367ValidPerfectSquare();
		System.out.println(p.isPerfectSquare(Integer.MAX_VALUE));
		System.out.println(p.isPerfectSquare(9));
	}

}
