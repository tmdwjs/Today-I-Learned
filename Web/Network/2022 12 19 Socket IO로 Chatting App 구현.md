# Socket

![image](https://user-images.githubusercontent.com/85447054/208381153-a355e348-d769-4732-b958-aa172a12422d.png)

## Server Socket
서버에서 클라이언트의 연결 요청을 받기 위해 만들어두는 일종의 문입니다. 포트를 지정해 해당 서비스의 호수를 지정합니다.

## socket
네트워크를 통해 TCP/IP 통신을 연결시켜주는 객체입니다. 클라이언트와 서버가 연결된 상태를 만들어 줍니다.

## flush()
버퍼에 쌓인 내용을 실제로 출력해주는 역할을 합니다. 버퍼 클래스의 출력(write)은, 실제 출력이 아닌 버퍼로 먼저 출력하게 됩니다. 따라서 flush() method를 사용해 실제로 출력해주는 과정이 필요합니다.