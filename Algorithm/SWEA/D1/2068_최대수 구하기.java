import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int i = 0; i < T; i++){
			int max = 0;
            
            for(int j = 0; j < 10; j++){
                int num = sc.nextInt();
                if(max < num) max = num;
            }
            
            System.out.println("#" + (i + 1) + " " + max);
		}
	}
}