### Socket

![image](https://user-images.githubusercontent.com/85447054/208381153-a355e348-d769-4732-b958-aa172a12422d.png)

#### Server Socket
서버에서 클라이언트의 연결 요청을 받기 위해 만들어두는 일종의 문입니다. 포트를 지정해 해당 서비스의 호수를 지정합니다.

#### socket
네트워크를 통해 TCP/IP 통신을 연결시켜주는 객체입니다. 클라이언트와 서버가 연결된 상태를 만들어 줍니다.

#### flush()
버퍼에 쌓인 내용을 실제로 출력해주는 역할을 합니다. 버퍼 클래스의 출력(write)은, 실제 출력이 아닌 버퍼로 먼저 출력하게 됩니다. 따라서 flush() method를 사용해 실제로 출력해주는 과정이 필요합니다.

### JavaFX
JavaFX는 자바에서 제공하는 GUI입니다. Chatting App을 구현하기 위해 UI가 필요해 사용했습니다.

```java

...

// Application import 해 오기
import javafx.application.Application;

// Application 상속
public class ChatAppClient extends Application{

  TextArea textArea; // text가 찍히는 공간
  Button connBtn; // button
  TextField ipTextField; // 입력창
  TextField idTextField;
  TextField chatTextField;
	
  // 자주 사용하는 method를 생성
  private void printMsg(String msg) {
  
    // textArea에 text를 입력할 수 있다.
    // ex) 서버와 연결됐습니다.
    Platform.runLater(() -> {
      textArea.appendText(msg + "\n");
    });
  }
	
  // start method가 실행되면서 화면이 구성됨
  @Override
  public void start(Stage primaryStage) throws Exception{
    // borderpane = 화면을 구성하는 layout
    BorderPane root = new BorderPane();
		
    // scene 객체를 생성해 root(layout)을 담기
    Scene scene = new Scene(root); // scene(장면)

    primaryStage.setScene(scene); // window에 장면을 붙이기
    primaryStage.setTitle("Chatting App"); // window title
    primaryStage.show(); // 보여주기
  }
	
  // main method
  public static void main(String[] args) {
    launch(); // start() method 실행
  }
}

```

### Client

### Server
