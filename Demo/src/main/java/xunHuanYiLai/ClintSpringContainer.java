package xunHuanYiLai;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * @date 2023/5/21 12:23
 */
public class ClintSpringContainer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);

    }
}
