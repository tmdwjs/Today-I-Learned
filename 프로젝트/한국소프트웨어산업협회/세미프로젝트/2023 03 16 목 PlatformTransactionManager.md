# PlatformTransactionManager

스프링에서 트랜잭션 관리를 위해 사용하는 인터페이스입니다. 스프링에서 트랜잭션 관리를 하기 위해선 두 가지가 있습니다. <code>PlatformTransactionManager</code> 인터페이스를 사용하거나 <code>@Transaction</code> 어노테이션 사용입니다.

이 둘의 차이점은 성능이 아닌 사용하는 방법과 목적에 따라 나뉘게 됩니다. <code>PlatformTransactionManager</code>는 더 세밀한 제어가 필요한 경우, <code>@Transaction</code> 어노테이션은 더 간편한 트랜잭션을 관리하기 위해 사용됩니다. 따라 상황에 맞는 방법을 선택해 사용하면 되고, 해당 프로젝트에서는 <code>PlatformTransactionManager</code> 인터페이스를 사용해 트랜잭션 관리를 했습니다.

```java
// Service

@Service
public class ServiceImpl implements Service {

  @Autowired
	private PlatformTransactionManager transactionManager; // 트랜잭션 매니저 객체 선언 및 자동 주입

  @Override
  public int createPost () {
    // 트랜잭션 매니저를 이용하여 트랜잭션을 시작하는 역할 수행
    TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

    int result = 0;

    try {
      if () {
        transactionManager.commit(status); // 트랜잭션 커밋

        return 1;
      }else {
        transactionManager.rollback(status); // 트랜잭션 롤백
      }
    } catch (Exception e) {
      transactionManager.rollback(status); // 트랜잭션 롤백
    }
  }

  return result;
}
```