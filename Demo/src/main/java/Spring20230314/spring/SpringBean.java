package Spring20230314.spring;

/**
 * @author yang
 * @date 2023/3/18 19:15
 */
public class SpringBean {
    /**
     * bean的作用域
     * 可以通过scope="",来制定bean的作用域
     * singleton默认值，当ioc容器以创建就回创建bean的实例，而且是单例的，每次得到的都是同一个
     * prototype：原型的，当ioc容器以创建不再实例化该bean，每次调用getBean方法时再实例化该bean，而且每次调用，每次创建
     * request，每次请求实例化一个bean
     * session，在一次会话中共享一个bean
     */
//    <bean id="book" class="com.yang.srb.Book" scope="singleton">

//    spring支持的常用数据库传播属性和隔离级别
    /**
     *  propagation:用来设置事务的传播行为
     *  propagation。REQUIRED默认值，使用原来的事务
     *  propagation。REQUIRED_NEW将原来的事务挂起，开启一个新事物
     *
     *  isolation：用来设置事务的隔离级别
     *  isolation。repeatable_read：可重复读，mysql默认的隔离级别
     *  isolation.read_committed:读已提交，Oracle默认的隔离级别，开发时通常使用的隔离级别
     */
//    @Transactional(propagation=Propagation.REQUIRED,isolation=isolation.DEFAULT)
}
