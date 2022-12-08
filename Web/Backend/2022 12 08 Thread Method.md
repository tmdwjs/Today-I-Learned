### 복습

java에서 thread 생성 후 실행, 이때 실행 code를 작동시키기 위해 run() 메서드를 제공 받아야 하고 이를 위해 thread class를 상속 받습니다.

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
  
  A r = new A(); // Runnable r = new A(); 가능
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

start() method를 제외한 나머지 method들은 현재 deprecated 됐습니다. 사용하기 편하지만 잦은 사용 시 dead-lock 상태로 빠졌기 때문입니다.

일시 중지나 재개, 종료를 위해 제공되는 method는 다음과 같습니다.

#### interrupt()
#### interrupted()
#### isInterrupted()


#### volatile

#### yield

#### 상태 전이도

otherwise blocked에서 runnable 가는 경우 두 가지
1. sleep timeout
2. interrupt exception

yield: running(수행 중인 상태에서) runnable로 빠짐

#### join

#### 상수 필드
