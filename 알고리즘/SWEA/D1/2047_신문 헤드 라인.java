import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in); // input
		String T = sc.nextLine(); // String 타입의 문자열 한 개만 들어오기 때문에, 다음과 같이 받기

    // 그대로 System.out.println을 통해 출력하며,
    // 문제에서 말한 대로 전부 대문자로 출력하기 위해 toUpperCase()를 사용
		System.out.println(T.toUpperCase());
	}
}