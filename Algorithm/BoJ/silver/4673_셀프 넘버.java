// https://www.acmicpc.net/problem/4673

package baekjoon.silver;

public class 셀프_넘버 {
	public static void main(String[] args) {
		boolean[] check = new boolean[10001];
		
		for (int i = 1; i <= 10000; i++) {
			if (isSelf(i) <= 10000) {
				check[isSelf(i)] = true;
			}
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (!check[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static int isSelf(int num) {
		int sum = num;
		
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		
		return sum;
	}
}
