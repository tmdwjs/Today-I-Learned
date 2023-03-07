import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
        
        for(int i = 0; i < word.length(); i++){
        	System.out.print((int)word.charAt(i) - 64 + " ");
          // str형.charAt(인덱스 번호(위치))
          // 64를 빼기 위해선, string 타입의 word.charAt(i)을 int로 형변환 해 줘야 한다
          // 즉 (int)word.charAt(i) - 64
        }
        
	}
}