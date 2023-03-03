# Spring + MyBatis

## 설정
1. MyBatis 3.5.9(MyBatis 모듈)
2. Spring - MyBatis 2.0.7(연동 모듈)
3. Spring - JDBC 5.3.23
4. MySQL Connector/J (MySQL DB 연결)

## 세팅
### mybatis-config.xml

이는 예전에 <code>SqlMapConfig.xml</code> 파일이며, 이 파일의 내용을 가지고 파일명을 바꿔 다시 만들겠단 의미입니다.
설정 파일인 이 파일은 <code>src/main/resources</code>에 위치합니다.

해당 파일에는 SQL 매핑 관련 설정을 수행하는데, 아래와 같은 설정이 추가됐습니다.

```xml
<!-- src/main/resources/mybatis-config.xml -->

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration 
          PUBLIC "-//mybatis.org/DTD Config 3.0//EN" 
          "http://mybatis.org/dtd/mybatis-3-config.dtd" >
<configuration>
	<settings>
		<setting name="jdbcTypeForNull" value="NULL" />
		<!-- 1. Log4J와 MyBatis를 연동해 쿼리문과 실행 결과를 로그로 출력 -->
		<setting name="logImpl" value="LOG4J2" />
	</settings>

	<!-- 2. 나중에 Alias를 사용할 일이 있을 때 지정해 사용해 준다. -->
	<typeAliases>
	</typeAliases>

  <!-- 3. 접속 환경 등 설정은 빈으로 따로 잡아줄 거라 주석 처리 하거나 지운다. -->
  <!-- <environment>
  
  </environment> -->
</configuration>
```

### database.properties
<code>DataSource</code>는 <code>Connection Pool</code>을 가지고 있는 객체입니다. 따라서 연결 정보가 있어야 만들 수 있습니다. 별도의 프로퍼티 파일로 작성합니다. 파일 위치는 <code>src/main/resources/config/database.properties</code>에 해당 파일명으로 위치하게 됩니다.

```properties
# src/main/resources/config/database.properties

db.driverClassName=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true
db.username=root
db.password=password
```

그리고 DataSource를 Bean으로 등록해야 합니다. 순서는 <code>DataSource</code> -> <code>SqlSessionFactory</code> -> <code>SqlSession</code>와 같이 흘러가며, 최종적으로는 <code>SqlSession</code>을 끌어다 사용할 수 있습니다.

### datasource-context.xml
```xml
<!-- src/main/webapp/WEB-INF/spring/datasource-context.xml -->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">


	<!-- src/main/resources 경로는 classpath에 포함된다.
  location 경로의 파일을 프로퍼티 파일로 불러와 사용하겠다는 설정 -->
	<context:property-placeholder
		location="classpath:config/database.properties" />

	<!-- dataSource를 Bean으로 등록한다.
  dataSource는 connection에 필요한 정보를 가지고 있다. -->
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName"
			value="${db.driverClassName}" />
		<property name="url" value="${db.url}" />
		<property name="username" value="${db.username}" />
		<property name="password" value="${db.password}" />
	</bean>

	<!-- sqlSessionFactory를 Bean으로 등록한다.
  SqlSessionFactory는 SqlSession을 만들기 위한 정보들을 가지고 있다.
  mapper를 생성하면 list에 추가해야 한다. -->
	<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation"
			value="classpath:mybatis-config.xml" />
		<property name="mapperLocations">
			<list>
				<value></value>
			</list>
		</property>
	</bean>

	<!-- sqlSession를 Bean으로 등록한다.
  기존의 sqlSession은 Thread-Safe하지 않아서 Bean으로 사용 시 
  Transaction처리에 문제가 발생할 수 있었다.
  
  하지만 여기서는 Thread-Safe한 SqlSessionTemplate 클래스를 사용하기 때문에
  Bean으로 등록해 사용이 가능하다. -->
	<bean id="sqlSession"
		class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactory" />
	</bean>
</beans>
```

<code>SqlSession</code>은 공유되면 안됩니다. 그래서 별도로 클라이언트별로 만들어 사용해야 합니다. 근데 지금 작성한 내용은 sqlsession을 bean으로 등록해 싱글톤 방식으로 공유해서 사용하려고 합니다.

스프링에서는 sqlsession을 bean으로 사용해도 클래스를 별도로 만들어 제공하기 때문에 동기화 문제가 발생하지 않아 사용이 가능합니다. 

```xml
<!-- web.xml -->

<context-param>
  <param-name>contextConfigLocation</param-name>
  <!-- <param-value>/WEB-INF/spring/root-context.xml</param-value> -->

  <!-- 기존 root-context.xml과 이번에 생성한 datasource-context.xml을 모두 불러오기 위해 -->
  <!-- -context.xml으로 작성된 xml 파일 전체에 대한 설정을 해 준다. -->
  <param-value>/WEB-INF/spring/*-context.xml</param-value>
</context-param>
```

### bookMapper.xml

<code>springweb/src/main/resources</code>에 <code>bookMapper.xml</code> 이름으로 생성합니다. mapper 파일에 관련된 내용은 다른 파일에서 다룰 예정입니다.

만들 파일을 <code>datasource-context.xml</code>에 등록해 줍니다.

### Book.java
 
VO도 생성합니다. 이 내용 또한 다른 파일에서 다룰 예정입니다.

### datasource-context.xml

```xml
<!-- datasource-context.xml에 mapper를 등록한 내용 -->
<property name="configLocation"
  value="classpath:mybatis-config.xml" />
<property name="mapperLocations">
```

### Log4j 연동

<code>log4j2.xml</code>을 열어 <code>Loggers</code> 태그 아래 <code>Logger</code> 태그를 추가합니다.

```xml
<!-- log4j2.xml -->
<?xml version="1.0" encoding="UTF-8"?>

<Configuration>
	<Loggers>
		<Logger name="myBook" level="trace"></Logger>
	</Loggers>
</Configuration>
```