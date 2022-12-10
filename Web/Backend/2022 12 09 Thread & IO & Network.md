### Join

<code>join()</code> method는 이름 그대로 참여하는, 중간에 껴 먼저 실행하게 만드는(?) method라 생각하면 편할 것 같습니다. 자바스크립트로 개발했던 저로선 배열의 출력 방식을 바꾸는 건가 싶었지만, 해당 method의 사용 방식은 다음과 같습니다.

interrupt() 사용 시, sleep 중인 thread를 깨우러 가면 main method는 기다려주지 않고 쭉 실행을 하게 됩니다. 병렬 진행이기 때문인데요. 그렇기 때문에 사전에 로직을 '0 이하로 떨어지게 되면 - 값이 되지 못하게 0을 대입하라'는 코드를 작성했음에도 - 값이 나오는 이상한 현상이 발생하게 됩니다.

따라서 이때는 병렬이 아닌 순차 진행이 돼야 하는데, 이럴 때 사용하는 게 <code>join()</code>입니다. 하지만 join()을 제대로 사용하지 않으면 무한 루프에 빠질 수 있게 됩니다. 예상하지 못한 이유로 종료되지 않는다면, join()이 끝나지 않을 수 있어 <code>join(timeout)</code>를 적용하면 join을 빠져나와 다음 작업을 처리할 수 있습니다.

---

### Synchronization(Thread 동기화)

> 하나의 Thread가 특정 작업을 마치기 전까지 다른 Thread에 의해 방해 받지 않도록 처리하는 것

#### Lock(락, 잠금) = monitor라고도 함

좌석 정보라는 공유 객체가 있다고 가정합니다. 그리고 옆에 Thread A와 Thread B가 같이 있습니다. 공유 객체는 <code>monitor</code>라는 걸 내부적으로 가지고 있는데, thread에 의해 사용 될 때 가장 먼저 접근한 thread에 대해 공유 객체가 monitor를 주게 됩니다(당연히 thread는 monitor(혹은 lock)를 할당 받게 됩니다.).

그렇기 때문에 다른 thread가 접근하면 공유 객체가 monitor가 없어서 monitor를 획득할 때까지 <code>block</code>이 되고 monitor를 획득하면 block이 풀립니다(순차 처리).

즉 monitor를 확인해서 monitor를 획득하기 위한 keyword가 <code>synchronized</code>이며, monitor가 없어 다른 thread들이 block 되는 것도 얘 역할이라 할 수 있습니다.

#### 공용 객체

thead에 의해 같이 사용하는 객체를 의미힙니다.

```java
...

public class Thread12 {
  public static void main(String[] args) {
    Thread12_1 r = new Thread12_1();
    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);
    t1.start();
    t2.start();
    // 이처럼 thread 두 개로 사용하면, 공용 객체에 문제가 발생해 - 값이 출력되는 오류가 발생한다.
    
      // ex
	// balance 300
	// t1 > 200원 차감
	// t2 > 200원 차감
	// t1 먼저 들어가서 sleep 상태에 들어가는 동안
	// t2 들어오는데, 아직 t1이 실행이 안 돼 balance가 여전히 300이기 때문에 이를 확인하고 sleep 상태가 됨
	// 즉, t1이 깨어나 100을 만들지만, t2는 여전히 300을 기준으로 생각하기 때문에, 200을 빼 -100이 출력된다.
		
    // 이러한 문제를 해결하기 위해 사용하는 게 synchronized keyword
      // 이를 사용하면 monitor를 획득할 수 있음
      // method 앞에 붙임
  }
}

...
```

<code>synchronized</code> keyword를 method 앞에 붙여 synchronized method를 만들어 줍니다.

하지만 이렇게 사용하게 되면 문제점이 한 가지 존재합니다. 

예를 들어 동기화가 필요한 부분은 적은데, method 자체가 길면, 적은 부분을 위해 통으로 다른 thread 사용을 block 한다 볼 수 있습니다. 즉, 필요한 일부분만 동기화 시키는 방법이 훨씬 효율적이라 할 수 있습니다.

이럴 때 <code>synchronized block</code> 사용하며 이때 해당 영역을 <code>임계영역(critical section)</code>이라고 합니다.

<img width="628" alt="image" src="https://user-images.githubusercontent.com/85447054/206843649-118db538-01dc-49df-9378-d6f3f27ecda6.png">


#### wait()

현재 임계 영역에서 실행 중인 Thread가 lock을 놓고 wait 상태로 전환하게 하는 method입니다. 스스로 lock을 놔 주는 행위를 실행하게 됩니다.

#### notify()
wait에 의해 일시중지 된 thread 중 하나를 runnable 상태로 전환해주는 것입니다. 깨워주는 표현이 어울리는 것 같습니다.

<img width="636" alt="image" src="https://user-images.githubusercontent.com/85447054/206843927-063985ee-3e63-4a59-aaca-b80b535b7cce.png">


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
