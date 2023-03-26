### XML
> XML 파일이 있어야 한다

<code>XML</code>은 문서의 구조가 미리 정해진 형태로 만들어졌는지 검증하는 기능이 있습니다. 즉 어떤 <code>XML</code>이냐에 따라 사용 가능한 태그와 태그의 구조로 이미 결정돼 있습니다. 이 검증은 두 가지로 작업 수행이 가능합니다.

1. DTD
2. Schema

<code>Schema</code>를 사용하면 네임스페이스를 이용해 추가적인 기능을 포함할 수 있기 때문에, 확장성이 더 큽니다. 따라서 스키마를 사용하는 것을 추천합니다. 그럼 이 파일은 어디에 만들어야 할까요? 어디에 만들어도 상관 없지만, 해당 과정에서는 <code>dao</code> 패키지 안에 생성하도록 하겠습니다.

> New - Spring Bean Configure File

통상 <code>xml</code>의 파일명은 <code>beans.xml</code> 혹은 <code>applicationContext.xml</code>로 지정해 줍니다.

### XML 설정

#### XML 파일 생성
앞서 말했듯 xml의 파일명은 통상적으로 <code>beans.xml</code> 혹은 <code>applicationContext.xml</code>로 작성합니다.

#### bean: 기본 구문
<code>beans.xml</code> 혹은 <code>applicationContext.xml</code>에서 다음과 같이 <code>bean</code>을 추가할 수 있습니다.

```xml
<beans>
	<bean id="bean의 식별자" class="bean을 사용하는 class" scope="singleton">
	<!-- singleton은 default이기 때문에 작성하지 않아도 됨 -->

		<!-- 생성자에 주입 -->
		<constructor-arg>
			<value></value>

			<!-- value의 속성으로 index와 type을 지정 가능하며, 생략 가능하다 -->
			<value index="0" type="java.lang.String"></value>
			<value index="1" type="int"></value>
		</constructor-arg>

		<!-- setter에 주입 -->
		<property>
			<value></value>
		</property>
	</bean>
</beans>
```

#### bean: 직접 해 보기
```xml
<beans>
	<bean id="messageBean" class="springioc.sample1.MessageBeanImpl"> 

		<!-- 기본 생성자가 아닌 MessageBeanImpl 생성자를 호출할 때 어떻게 해야 하나?
		constructor-arg를 사용해서 가능하다 -->
		<constructor-arg>
			<!-- 생성자 만들 때 딸기라는 값을 주라는 거임(fruit을 인자로 받고 있으니까) -->
			<value>딸기</value>
		</constructor-arg>

		<!-- 아니면 이처럼 property를 통해 setter를 호출이 가능함 -->
		<property name="cost">
			<value>3000</value>
		</property>
	</bean>
</beans>
```
<code>constructor-arg</code>는 생성자를 호출, <code>property</code>는 setter에 주입할 때 사용합니다. <code>constructor-arg</code> 혹은 <code>property</code> 태그 안에 <code>value</code> 태그를 삽입하지 않고, 속성으로 추가가 가능합니다.

#### bean: 다르게 해 보기
```xml
<beans>
	<bean id="messageBean" class="springioc.sample1.MessageBeanImpl">
		<constructor-arg value="딸기" /> <!-- 생성자에 주입 -->
		<property name="cost" value="3000" /> <!-- setter에 주입 -->
	</bean>
</beans>
```

#### bean: value에 bean을 넣고 싶으면?
```xml
<beans>
	<bean id="obj1" class="springioc.sample3.User">
		<constructor-arg value="백승전" />
	</bean>
	
	<bean id="myService" class="springioc.sample3.UserServiceImpl">
		<constructor-arg ref="obj1" /> <!-- ref는 bean을 넣는 것 -->
	</bean>
</beans>
```

#### bean: 추상 클래스를 bean으로 등록
```java
...
public abstract class AbstractDay {
	public abstract String dayInfo(); // 추상 메서드가 하나 있음

	public static AbstractDay getInstance() {
		// 오늘 날짜의 요일을 알아보자
		GregorianCalendar cal = new GregorianCalendar();

		int day = cal.get(Calendar.DAY_OF_WEEK); // 해당 날짜에 대한 요일을 숫자로 알려줌
		
		AbstractDay myDay = null;
		
		switch(day) {
		case 1:
			myDay = new Sunday();
			break;
		case 2:
			myDay = new Monday();
			break;
		case 3:
			myDay = new Thuesday();
			break;
		}
		
		return myDay;
	}
}

// 이처럼 객체를 만들어내는 method를 factory method라고 함
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="day" class="springioc.sample4.AbstractDay" factory-method="getInstance" />
	<!-- 추상 클래스이지만 Bean으로 등록해서 사용 가능  -->
	<!-- 객체를 만들 수 없는 상황에서 Bean을 만들기 위해 factory-method를 많이 사용함 -->
</beans>

```

#### c & p schema
이제는 <code>constructor-arg</code>, <code>property</code>과 같이 사용하는 것도 깁니다. 이때 <code>c schema</code>와, <code>p schema</code>를 사용해 더욱 축약해 사용이 가능합니다. 눈치채셨겠지만, <code>c schema</code>는 <code>constructor-arg</code>, <code>p schema</code>는 <code>property</code>를 축약해 사용합니다.
```xml
<beans 
	xmlns:c="http://www.springframework.org/schema/c"
	xmlns:p="http://www.springframework.org/schema/p">
	<bean id="messageBean" class="springioc.sample1.MessageBeanImpl">
		<constructor-arg value="딸기" /> <!-- 생성자에 주입 -->
		<property name="cost" value="3000" /> <!-- setter에 주입 -->
	</bean>
</beans>
```