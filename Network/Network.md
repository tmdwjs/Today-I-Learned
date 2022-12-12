### Network

> 컴퓨터 간 데이터를 주고받기 위해 여러 개의 컴퓨터를 연결(무선 or 유선)해 놓은 물리적인 망<br>
> 일반적으로 크기를 기준으로 여러가지 네트워크를 구성

- PAN(Personal Area Network)
- LAN(Local Area Network)
- ...
- Internet

### Service
- email
- www
- ftp
- torrent
- ...

네트워크를 통해 컴퓨터가 데이터를 통신하려면, 네트워크 각 컴퓨터에게 논리적인 주소<code>IP Adress</code>를 부여합니다.

### Protocol

> 데이터를 주고받기 위해 통신을 하기 위한 규칙(역할과 규칙)

### Port
> 16bit짜리 숫자<br>
> 0 ~ 65535 사이의 값을 사용하며, 0 ~ 1023은 예약돼 있다 = well known port

port는 하나의 컴퓨터에서 실행되는 프로그램에 할당할 수 있는 번호입니다. port의 경우, 겹치지 않게 유니크하게 사용하지만 무조건 사용하지 못하는 건 아닙니다.
하지만 <code>ip address</code>와 <code>port</code> 번호가 있어야 상대방 Process를 식별하고 데이터를 주고 받을 수 있기 때문에 중복하여 사용하는 걸 지양합니다.

### Socket
> 데이터 통신을 위해 port를 추상화 한 것

#### C/S 구조
> Client / Server 구조

<code>server</code>는 client가 접속하기를 기다리다가 접속이 들어오면 응답합니다. 

<code>client</code>는 능동적으로 서버에 접속하는 process입니다.

server와 client가 데이터 통신을 하려면 socket이라 불리는 객체가 양 단에 하나씩 있어야 합니다. server는 client 접속을 기다려야 하고, 만약에 접속이 들어오면 연결해야 합니다. client가 Server 내부에 <code>Server socket</code>에 접속하게 되면, 얘가 socket을 생성하게 됩니다.
