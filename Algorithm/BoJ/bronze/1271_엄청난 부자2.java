// https://www.acmicpc.net/problem/1271

package baekjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Main23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger money = sc.nextBigInteger();
		BigInteger people = sc.nextBigInteger();
		BigInteger answer = money.divide(people);
		BigInteger changes = money.remainder(people);
		
		System.out.println(answer);
		System.out.println(changes);
	}
}