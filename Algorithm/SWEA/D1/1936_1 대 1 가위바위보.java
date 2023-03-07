// https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AV5PjKXKALcDFAUq

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(a > b) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
	}
}
