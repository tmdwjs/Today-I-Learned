### Join

interrupt() 사용 시, sleep 중인 thread를 깨우러 가면 main method는 기다려주지 않고 쭉 실행을 하게 됩니다. 병렬 진행이기 때문인데요. 그렇기 때문에 사전에 로직을 '0 이하로 떨어지게 되면 - 값이 되지 못하게 0을 대입하라'는 코드를 작성했음에도 - 값이 나오는 이상한 현상이 발생하게 됩니다. 따라서 이때는 병렬이 아닌 순차 진행이 돼야 하는데, 이럴 때 사용하는 게 <code>join()</code> 메서드입니다.

하지만 join()을 제대로 사용하지 않으면 무한 루프에 빠질 수 있게 됩니다. 예상하지 못한 이유로 종료되지 않는다면, join()이 끝나지 않을 수 있어 <code>join(timeout)</code>를 적용하여 ms 단위로 시간을 적용하면 join을 빠져나와 다음 작업을 처리할 수 있어 이처럼 사용도 가능합니다.

```java
...

public class Class{
  public static void main(String[] args){
    Runnable r = new Temp();
    Thread t = new Thread(r);
    
    ...
    
    try{
      t.join();
    }catch(){
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

...
```

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

Java Program < - Stream - > 모니터 (표준 출력)

<img width="386" alt="image" src="https://user-images.githubusercontent.com/85447054/206845485-427c1a5a-56d2-4331-8c8e-2dc58858aa17.png">


#### stream
stream 종류에는 입력 stream과 출력 stream으로 2가지가 존재합니다.

- stream은 단방향
- stream은 FIFO(First In First Out) 구조
- 결합해서 사용할 수 있다
- Stream에는 두 개의 class가 존재한다.
  - InputStream(class)
    - read()
    - byte[] 상태로 읽어온다
  - OutputStream(class)
    - write()
    - byte[] 상태로 출력한다
- Stream은 byte 단위의 Stream과 문자 단위의 Stream으로 구분한다

#### 문자열 I/O

<img width="633" alt="image" src="https://user-images.githubusercontent.com/85447054/206849172-0faea3c0-ef8d-46d2-8f8a-6ea190a9bdd5.png">


```java
...

public class IO01 {
  public static void main(String[] args) {
    System.out.println("키보드로 한 줄을 입력하세요");
		
    // 키보드로부터 입력을 받으려면, 데이터 연결 통로(stream)이 있어야 한다.
    // InputStream Class의 객체인 System.in이 제공된다.
    
    // 근데 사용하기 너무 불편해,
    // 문자 기반의 데이터를 받기 원하니 Reader 하나 만들어야 한다
    // new InputStreamReader(System.in) 이렇게 Stream을 좀 더 결합해 사용이 가능하다
    
    // 그럼에도 불편해,	
    // 그래서 다음처럼 데이터 입력 연결 통로를 만들었다
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      String s = br.readLine();
      System.out.println("입력 받은 데이터는: " + s);
      
      } catch (IOException e) {
			
      }
  }
}

...
```

#### Object I/O

```java
...

public class IO02 {
  public static void main(String[] args) {
    // 저장 할 HashMap부터 있어야 함
    HashMap<String, String> map = new HashMap<String, String>();

    map.put("1", "백승전");
    map.put("2", "손석구");
    map.put("3", "유아인");

    // 실제 file을 생성하려면 당연히 자바 쪽에서 file 객체를 만들어야 함
    File file = new File("readme.txt");

    try {
      FileOutputStream fos = new FileOutputStream(file);
      // FileOutputStream으로 객체로 보낼 수 없음
      // 따라서 확장해서 보내야 됨
      // 다시 말해 객체를 보낼 수 있는 stream으로 만들면 됨
      
      // 이것이 바로 Object Output Stream
      ObjectOutputStream obfos = new ObjectOutputStream(fos);
      
      // 얘에 대한 exception 처리를 해 줘야 하는데,
      // 번거롭게 그러지 말고 현재 try catch 구문에서 한 번에 최상위 exception으로 처리

      obfos.writeObject(map);

    }catch (Exception e) {

    }
  }
}

...
```

---

### Network

#### LAN(Local Area Network)

<img width="764" alt="image" src="https://user-images.githubusercontent.com/85447054/206854356-b97a747b-241c-40e6-b692-c6034f815eb0.png">


#### service

물리적인 network 위에서 돌아가는 프로그램을 <code>service</code>라고 합니다. 대표적인 인터넷 서비스로는 다음과 같은 것들이 존재합니다.
- email
- web service
- torrent
- ftp
- ...

#### IP Address

인터넷에 연결되어 있는 각 컴퓨터들이 데이터 통신을 하려면 주소가 필요합니다. 이 주소를 <code>IP Address</code>라고 하며 <code>NIC(Network Interface Card)</code>에 할당됩니다.

IP 주소는 논리적인 주소이며 이는 임의로 변경이 가능합니다. 결국 물리적인 주소가 필요한데, 이를 <code>MAC Address</code>라고 합니다.

#### DNS(Domain Name System)

IP주소는 12자리의 숫자로 구성돼 사람이 기억하기 힘들어 이를 문자로 표현한 주소를 의미합니다. 

<img width="783" alt="image" src="https://user-images.githubusercontent.com/85447054/206855485-483cd30e-2763-417b-8a90-5abd6825f81a.png">


#### Protocol
> 국가 간의 약속
>> CS에서 Protocl의 의미는 데이터 통신을 위해 정해놓은 약속과 규칙을 의미

모든 데이터 통신에는 <code>protocol</code>이 존재합니다. Web Service는 <code>HTTP</code>란 Protocol을 통해서 데이터를 전달합니다. 하지만 이러한 과정이 복잡하고 어려웠고,
쉽게 쓰기 위해 나온 게 <code>Socket</code>입니다.


#### Socket

<img width="693" alt="image" src="https://user-images.githubusercontent.com/85447054/206855982-a1df70de-cba9-4c5c-89b2-ffdfecae0530.png">

