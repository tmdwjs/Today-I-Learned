### 백준

#### 문제
https://www.acmicpc.net/submit/17202

#### 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    try {
      String phoneNum1 = br.readLine();
      String phoneNum2 = br.readLine();
      String mixNum = "";

      // 두 개의 번호를 교차하여 넣어주고,
      for (int i = 0; i < phoneNum1.length(); i++) {
        mixNum += phoneNum1.charAt(i);
        mixNum += phoneNum2.charAt(i);
      }

      // 반복문을 돌린다.
      // 반복문이 돌수록, 교차로 입력된 번호는 줄어들면서,
      // 최종적으로 두 자리 숫자를 return 할 것이라, 
      // 교차된 번호의 길이가 2보다 클 때만 반복문이 돌 수 있게 코드를 작성한다.
      while (mixNum.length() > 2) {
        String tempNum = ""; // 현재 교차된 번호에 계속 재할당 해 줄 변수 생성

        // 교차 번호 전체 길이보다 1만큼 반복을 덜 돌아야,
        // 현재와 현재 기준 다음 번호의 합을 구할 수 있다.
        for (int j = 0; j < mixNum.length() - 1; j++) {
          int sumNum = 0;

          // 변수에 현재 숫자와 그 다음 숫자를 더해서 담을 건데,
          // char을 int로 형변환 해 줘야 함 > Character.getNumbericValue
          sumNum += Character.getNumericValue(mixNum.charAt(j))
            + Character.getNumericValue(mixNum.charAt(j + 1));
					
          // 8 + 4 = 12, 2를 담아야 함
          // 즉, 더한 값을 10으로 나눈 값의 나머지를 담아주면 된다.
          tempNum += sumNum % 10;
        }
				
        // 믹스 번호에 번호 두 개를 더한 값의 일의 자리를 재할당 해 준다.
        // 이러면 자연스레 계속 길이가 짧아지기 때문에, 반복문은 알아서 종료됨.
        // 반복문이 종료되는 시점은 최종적으로 두 자리의 번호가 return 된다.
        mixNum = tempNum;
      }

      System.out.println(mixNum);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```

#### 노트

<code>charAt(int)</code>: <code>String</code>으로 저장된 문자열 중 하나를 <code>char</code>로 변환해 줍니다.

<code>Character.getNumbericValue</code>: 숫자 형태의 <code>char</code> 타입을 <code>int</code>로 변환해 줍니다.
