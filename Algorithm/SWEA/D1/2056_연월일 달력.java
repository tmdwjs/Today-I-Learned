import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for(int i = 0; i < tc; i++){
			// 월에 따른 일자들[31, 28, ..., 31]
            // 연, 월, 일 변수
            int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            // 글자를 자르려면, substring, 그리고 String으로 받아와야 함.
            // 나중에 Integer.parseInt()을 사용해 int 타입으로 변환
            String str = sc.next();
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            String day = str.substring(6, 8);
            
            if(
            	Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12
                &&
                Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= days[Integer.parseInt(month)-1]
            ){
           	 	System.out.println("#" + (i+1) + " " + year + "/" + month + "/" + day);
            }else{
            	System.out.println("#" + (i+1) + " " + -1);
            }
		}
	}
}