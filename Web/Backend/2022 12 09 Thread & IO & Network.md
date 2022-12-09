### Synchronization(Thread 동기화)

> 하나의 Thread가 특정 작업을 마치기 전까지 다른 Thread에 의해 방해 받지 않도록 처리하는 것

#### 1. Critical Section(임계영역)

#### 2. Lock(락, 잠금) = monitor라고도 함

좌석 정보라는 공유 객체가 있음
그리고 옆에 Thread A와 Thread B가 같이 있음
공유 객체가 monitor라는 걸 내부적으로 가지고 있는데, Thread에 의해 사용 될 때
가장 먼저 접근한 Thread에 대해 공유 객체가 monitor를 줌(이때 Thread는 monitor 혹은 lock을 할당 받게 됨)
그렇기 때문에 다른 Thread가 접근하면 공유 객체가 monitor가 없어서 block이 돼 버림(monitor를 획득할 때까지)
그래서 thread는 접근이 안 되고 monitor를 획득하면 block이 풀림 > 순차 처리가 됨

monitor를 확인해서 monitor를 획득하기 위한 키워드 > synchronized(monitor가 없어 다른 thread들이 block 되는 것도 얘 역할)

### 공용 객체

thead에 의해 같이 사용하는 객체를 의미힙나디.
class로 정의하고 thread가 같이 사용하는 것입니다.

공용 객체를 만들고 걔를 class로 사용해야 함

```java
public class Thread12 {
	public static void main(String[] args) {
		Thread12_1 r = new Thread12_1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		// 이처럼 thread 두 개로 사용하면, 공용 객체에 문제가 발생해 - 값이 출력되는 오류가 발생한다
			// ex
			// balance 300
			// t1 > 200원 차감
			// t2 > 200원 차감
			// t1 먼저 들어가서 sleep 자는 동안, t2 들어오는데, t1이 자느냐 balance가 여전히 300이기 때문에 동시 진행
		
		// 이러한 문제를 해결하기 위해 사용하는 게 synchronized keyword
			// 이를 사용하면 monitor를 획득할 수 있음
			// method 앞에 붙임
	}
}
```

<code>synchronized</code> keyword를 method 앞에 붙여 synchronized method를 만들어 줍니다.

문제점

1. 방식의 문제

method의 실행이(=코드) 길다.

동기화가 필요한 부분은 적은데, method 자체가 길면, 적은 부분을 위해 통으로 다른 thread 사용을 block 한다 볼 수 있음
즉, 필요한 일부분만 동기화 시키는 방법이 훨씬 효율적임 > <code>synchronized block</code> 사용

해당 영역을 임계영역(critical section)이라고 함.

running 상태에서 synchronized를 만나면 Object's lock pool로 이동

#### wait()

현재 임계 영역에서 실행 중인 Thread가 lock을 놓고 wait 상태로 전환하는 method
임의로 스스로 lock을 놔 주는 행위

#### notify()
wait에 의해 일시중지 된 thread 중 하나를 runnable 상태로 전환해주는 것

상태 전이도로 보면,

runnable > running
running에서 synchronized를 만나면 object's lock pool로 ㄱ ㄱ 
running엣 wait 걸리면 objects wait pool로 이동

wait 걸려서 wait pool 간 애들한테 nofity를 걸어주면 runnable로 빠지게 됨(다른 thread가 실행해 줘야 하는 거)

---

### JAVA I/O

input, output
JAVA IO > 확장된 거 > NIO
자바 입출력 관련된 내용
Java.io package

Java Program < - Stream - > 모니터 (표준 출력)

Java에서 File에 데이터를 저장

#### stream
stream 종류에는 2가지가 있습니다.
입력 stream과 출력 stream(따로 존재합니다)

1. stream은 단방향
2. stream은 FIFO(First In First Out) 구조
3. 결합해서 사용할 수 있다

InputStream(class) OutputStream(class)

InputStream은 read(), byte[] 상태로 읽어드려요
OutputStream write() byte[] 상태로 출력

4. Stream은 byte 단위에 Stream과

기본 Stream은 사용하기 어렵다
특히 문자열 기반의 입출력을 많이 하는데 기본 Stream으로는 너무 힘들어

Input Stream > Input Stream Reader > Buffered Reader 
이를 Stream 결합이라고 함

결국 Stream이 데이터 연결 통로
입력 
- BufferedReader 이용
출력
- 모니터: System.out 제공된 Stream을 이용
- 일반 용도: PrintWriter

위에까진 문자열 기반 저 두 개만 생각하면 됨

그럼 객체를 받아오고 내보내려면? 

HashMap을 File에 저장


Serializable interface를 구현하고 있어야 함

Marshaling
전달될 때 데이터가 변환될 때를 마샬링이라 말함


---

### Network

#### Internet

LAN (Local Area Network)

물리적인 망 위에서 돌아가는 프로그램 = service라고 함

대표적인 인터넷 서비스 = email, web service, torrent, ftp


internet 에 연결되어 있는 각 computer가 데이터 통신을 하려면 "주소"가 필요
이 주소가 <code>ip address</code>
NIC(Network Interface Card)에 할당


#### 3. ip 주소는 논리적인 주소, 이는 임의로 변경이 가능, 결국 물리적인 주소가 필요
물리적인 주소 > MAC Address 
IPv4 주소는 논리적인 주소

#### DNS(Domain Name System)
IP주소는 숫자라 사람이 기억하기 힘들어서 문자로 표현함 이게 Domain

Domain Name > IP 주소 > MAC 주소 순서로 

#### Protocol
> 국가 간의 약속
>> CS에서 Protocl의 의미는 데이터 통신을 위해 정해놓은 약속과 규칙을 의미

Web Service > Protocol을 통해서(HTTP) 데이터를 전달

결국 너무 복잡하고 너무 어려워
버클리에서 쉽게 쓰기 위해 나온 게 Socket

자바 프로그래밍에서 socket 연결하면 사용 가능
