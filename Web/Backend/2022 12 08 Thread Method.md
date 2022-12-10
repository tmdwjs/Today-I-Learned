### thread

java에서 thread 생성하고 실행 코드를 작동시키기 위해서는 run() 메서드를 제공 받아야 합니다. 그리고 이를 위해 thread class를 상속 받습니다.

```java
Class A extends Thread{
  @Override
  run(){
  
  }
}
```

```java
Class A implements Runnable{
  @Override
  run(){
  
  }
  
  A r = new A();
  Thread t = new Thread(r);
}
```

---

### thread를 제어하는 method

- start()
  - 시작 method
- ~~suspend()~~
  - ~~일시 중지 method~~
- ~~resume()~~
  - ~~재개 method~~
- ~~stop()~~
  - ~~종료 method~~

start() method를 제외한 나머지 method들은 현재 deprecated로 권장하지 않습니다. 사용하기 편하지만 잦은 사용 시 dead-lock 상태로 빠질 확률이 많기 때문입니다.

예를 들면, <code>stop()</code> method의 경우 사용 시 갑작스럽게 thread를 종료하게 되니 thread를 사용 중이던 자원들이 불완전한 상태로 남겨지게 됩니다. 아무튼 더 자세한 정보는 [oracle docs, Java Thread Primitive Deprecation 문서](https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html)에서 확인이 가능합니다.

다시 돌아와, 그래서 thread에서 thread를 제어하고 로직으로 일시 중지나 재개, 종료 처리를 가능하게 사용하는 method는 다음과 같습니다.

<code>interrupt()</code> <code>interrupted()</code> <code>isInterrupted()</code>

```java
package study.thread;

import javax.swing.JOptionPane;

// Thread Class 상속
class Thread06_01 extends Thread{
	
  @Override
  public void run() {
    int i = 10;

    while(i != 0 && !isInterrupted()) {
      System.out.println(i--);

	try {
	  Thread.sleep(2000); // 2초 + a마다 재우고 깨우고를 반
	} catch (InterruptedException e) {
	  interrupt();	// sleep 상태에서 깨면서 interrupt()를 초기화 한다.
          // 동시에 InterruptException이 발생해 catch 구문으로 빠지게 된다.
          // 따라서 interrupt를 위해 해당 블록에서 interrupt를 한 번 더 실행해 줘야 함
      }
    }

    System.out.println("finish");
  }
}

// main Class
public class Thread06 {
  public static void main(String[] args) {
    Thread t = new Thread06_01(); // thread 객체 생성 
    t.start(); // thread start
		
    // 사용자 입력창
    String data = JOptionPane.showInputDialog("input");
    System.out.println(data);
		
    t.interrupt(); // thread에 interrupt 실행
       		  // 만약 interrupt를 걸었는데 해당 Thread 하필 sleep 상태면,
		  // sleep 상태에서 일어나기만 할 뿐, 일어나면서 interrupt를 초기화 한다.
  }
}

```

---

### volatile

자바 코드의 변수를 'Main Memory에 저장'할 것을 명시하기 위해 쓰입니다. <code>volatile</code> 변수는 변수의 값을 read 할 때마다 <code>CPU Cache</code>에 저장된 값이 아닌, Main Memory에서 읽는 것입니다.

CPU 내에는 성능 향상을 위해 <code>L1 Cache</code>가 내장돼 있습니다. CPU 코어는 메모리에서 읽어온 값을 캐시에 저장하고, 캐시에서 값을 읽어 작업합니다. 하지만 캐시에 저장된 값을 사용하는 게 아닌, 변경된 값을 적용해야 할 때가 있습니다. 이럴 때 volatile keyword를 사용해야 합니다.

```java

...

class Thread08_1 implements Runnable{
  // suspended와 stopped 변수를 생성해, 초기값을 false로 설정
  // 이후 상황에 맞게 true와 false를 할당해 중단과 재개, 멈춤 기능을 하는 로직을 작성할 예정
  // 하지만 volatile keyword를 붙이지 않으면 cache에 저장된 값을 사용하기 때문에 실제로는 실행이 안됨
  // 이럴 때 사용하는 keyword가 volatile
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	@Override
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					
				}
			}
		}
	}
	
	// 기존 suspend(), resume(), stop() method가 deprecated 상태라 권장 x
	// 같은 역할을 하는 method를 만들어 준 것
	// return 값이 없으니 void type 지정
	public void suspend() {suspended = true;}
	public void resume() {suspended = false;}
	public void stop() {stopped = true;}
}

public class Thread08 {
	public static void main(String[] args) {
  
		Thread08_1 r1 = new Thread08_1(); 
		Thread08_1 r2 = new Thread08_1();
		Thread08_1 r3 = new Thread08_1();
		
		Thread t1 = new Thread(r1, "*");
		Thread t2 = new Thread(r2, "**");
		Thread t3 = new Thread(r3, "***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			r1.suspend(); // r1 일시 중단
			
			Thread.sleep(2000);
			r2.suspend(); // r2 일시 중단
			
			Thread.sleep(2000);
			r1.resume();	// r1 재개
			// 하지만 역시나 재개가 안 됨 왜?
                    	// cache에 저장된 값을 사용했기 때문에
			// cache 메모리를 사용하지 않으려면 volatile keyword 사용
			/ 멀티 스레드 시, 바뀐 값을 적용할 수 있게 해 주는 변수
			
		} catch (Exception e) {
			
		}	
	}
}

...

```

---

### yield

<code>yield</code> method는 양보하는 method입니다. 

```java

...

class Thread08_1 implements Runnable{
  // suspended와 stopped 변수를 생성해, 초기값을 false로 설정
  // 이후 상황에 맞게 true와 false를 할당해 중단과 재개, 멈춤 기능을 하는 로직을 작성할 예정
  // 하지만 volatile keyword를 붙이지 않으면 cache에 저장된 값을 사용하기 때문에 실제로는 실행이 안됨
  // 이럴 때 사용하는 keyword가 volatile
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	@Override
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					
				}
			}else {
        Thread.yield();	// if else문에 의해 해당 block은 suspended 상태에 실행된다.
								        // 즉 suspended일 때 다른 thread에게 core 양보를 위해 yield 처리 해 준다.
      }
		}
	}
	
	// 기존 suspend(), resume(), stop() method가 deprecated 상태라 권장 x
	// 같은 역할을 하는 method를 만들어 준 것
	// return 값이 없으니 void type 지정
	public void suspend() {suspended = true;}
	public void resume() {suspended = false;}
	public void stop() {stopped = true;}
}

public class Thread08 {
	public static void main(String[] args) {
  
		Thread08_1 r1 = new Thread08_1(); 
		Thread08_1 r2 = new Thread08_1();
		Thread08_1 r3 = new Thread08_1();
		
		Thread t1 = new Thread(r1, "*");
		Thread t2 = new Thread(r2, "**");
		Thread t3 = new Thread(r3, "***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			r1.suspend(); // r1 일시 중단
			
			Thread.sleep(2000);
			r2.suspend(); // r2 일시 중단
			
			Thread.sleep(2000);
			r1.resume();	// r1 재개
			// 하지만 역시나 재개가 안 됨 왜?
                        // cache에 저장된 값을 사용했기 때문에
			// cache 메모리를 사용하지 않으려면 volatile keyword 사용
			// 멀티 스레드 시, 바뀐 값을 적용할 수 있게 해 주는 변수
			
		} catch (Exception e) {
			
		}	
	}
}

...

```

위 코드를 보면 <code>suspend()</code>는 사실 '멈춰 보이는' 것이지 멈춘 것이 아닙니다. 그렇기 때문에 여전히 core를 차지하고 있는데, 이를 다른 thread에게 양보해줘야 합니다. 그래야 멈춰 있는 동안 다른 thread가 core를 사용할 수 있고, 단순 멈춰 보이는 게 아닌 실제로 멈춰 있는 기능을 수행하는 것이기 때문입니다. 그리고 이를 가능하게 하는 게 <code>yield</code>입니다.

			
#### 상태 전이도

<pre>
otherwise blocke에서 runnable 가는 경우 두 가지
1. sleep timeout
2. interrupt exception

yield()를 사용하면 running(수행 중인 상태)에서 runnable로 빠지게 된다.
</pre>

<img width="632" alt="image" src="https://user-images.githubusercontent.com/85447054/206841488-8e30acb0-001e-4fbc-a02a-0f16fcd8e006.png">
