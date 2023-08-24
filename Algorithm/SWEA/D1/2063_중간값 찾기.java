// import java.util.Scanner;
// import java.io.FileInputStream;
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
        
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
        
        int[] arr = new int[T]; // 숫자들을 담을 배열
        
        // 반복문을 통해 배열에 숫자들을 담아주기
		for(int i = 0; i < T; i++){
            int num = sc.nextInt();
            arr[i] = num;
		}
        
        Arrays.sort(arr); // 오름차순 정렬
  		
        int mid = arr.length / 2; // 중앙값 인덱스
        System.out.println(arr[mid]); // 원래대로면 소수점으로 떨어질 수 있어 버림을 하지만,
        											 // 항상 홀수개로 주어지기 때문에, 나누어 떨어져 버림 과정은 생략했다.
	}
}