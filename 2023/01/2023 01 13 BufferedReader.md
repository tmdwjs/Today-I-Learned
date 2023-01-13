### 자바 입출력
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
    // 자바로 입출력을 받기 위해
    // Scanner sc = new Scanner(System.in);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 두 가지 방식이 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력 받아온 값을 자르기 위해
    // split method
    // StringTokenizer 클래스
    // 두 가지 방식이 있음
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	}
}
```

---

### Scanner와 BufferedReader

#### Scanner
입력 받을 때 <code>정수</code>, <code>소수</code>, <code>문자</code> 데이터도 구분 지을 수 있습니다. 즉, 직관적이고 사용하기에 편리하단 장점이 존재합니다.

하지만 키보드 입력 시, 키를 누르는 즉시 바로 전달되기 때문에 버퍼를 사용하는 <code>BufferedReader</code>보다 속도 면에서 불리하다는 단점이 존재합니다.

#### BufferedReader
<code>Scanner</code>는 띄어쓰기와 개행문자를 기준으로 입력 값을 인식하는 것에 반면, <code>BufferedReader</code>는 개행문자만 경계로 인식하고 데이터 형식이 String으로 고정되어 있기 때문에 추가 가공이 필요합니다.

그리고 입력 받은 값을 <code>16384 byte</code> 크기의 버퍼에 담아 두었다 한 번에 프로그램에 전송하는데, 어떻게 보면 받는 즉시 전송하는 Scanner가 더 효율적이고 빠르다 생각하겠지만, 과일 수확 시, 과일 하나를 수확할 때마다 옮기는 것과, 바구니에 담아 한 번에 옮기는 것을 생각해 보면 후자가 더 효율적인 것을 느낄 수 있습니다.

BufferedReader에서는 예외 처리가 필수이시 때문에 <code>try catch</code>문 혹은 <code>throws IOException</code> 처리를 해 줘야 하며, 입력을 받기 위해선 <code>readLine()</code> 메서드를 사용해야 합니다.

---

### Split과 StringTokenizer

#### split
입력 받는 동시에 별 다른 처리 없이 배열로 데이터를 받아올 수 있습니다.

#### StringTokenizer
하지만 <code>StringTokenizer</code>의 경우 토큰화 된 문자열을 다시 처리해 줘야 하는데요. 생성자에서 추가적인 구분자를 명시하지 않으면 default로 띄어쓰기로 구분되며, 다른 구분자 사용 시, <code>StringTokenizer st = new StringTokenizer(문자열, 구분자);</code>로 작성하면 됩니다.
