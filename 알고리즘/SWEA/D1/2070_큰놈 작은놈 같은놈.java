import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int i = 0; i < T; i++){
            String ans = "";
            
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            
            if(num1 == num2) ans = "=";
            if(num1 > num2) ans = ">";
            if(num1 < num2) ans = "<";
            
			System.out.println("#" + (i + 1) + " " + ans);
		}
	}
}