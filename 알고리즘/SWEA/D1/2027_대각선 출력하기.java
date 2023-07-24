//https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AV5QFuZ6As0DFAUq

package swea;

import java.util.Arrays;

public class Main3 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i == j) {
					System.out.print("#");
				}else {
					System.out.print("+");
				}
			}
			
			System.out.println("");
		}
	}
}