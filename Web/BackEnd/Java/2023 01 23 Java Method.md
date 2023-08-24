# DecimalFormat
> 자바 문자열 포맷

```java
public class Main {
  public static void main(String[] args) {
    int n = 1000000;
    
    DecimalFormat df = new DecimalFormat("###,###");
    String str = df.format(n);
		
    System.out.println(str); // 1,000,000
  }
}
```

# Math

```java
public class Main {
  public static void main(String[] args){
    // Math.pow(n, m) // n ** m
    double num1 = Math.pow(10, 1);
    double num2 = Math.pow(10, 2);
    double num3 = Math.pow(10, 3);
    
    System.out.println(num1); // 10.0
    System.out.println(num2); // 100.0
    System.out.println(num3); // 1000.0
    
    // Math.PI
    double num4 = Math.PI;
    
    System.out.println(num4); // 3.141592653589793
    
    // Math.round(n) // 반올림
    double num5 = Math.round(Math.PI);
    double num6 = Math.round(Math.PI * num1) / num1; // num1 = 10.0
    double num7 = Math.round(Math.PI * num2) / num2; // num2 = 100.0
    
    System.out.println(num5); // 3.0
    System.out.println(num6); // 3.1
    System.out.println(num7); // 3.14
  }
}
```
