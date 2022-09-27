package yang;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

@Data
@AllArgsConstructor
class User{
    String userName;
    int age;
}

/**
 * ABA问题，通过原子引用+版本号（时间戳）
 * @author yang
 * @date 2022/7/27 14:29
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User yang = new User("yang", 12);
        User li = new User("li", 21);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(yang);
        System.out.println(atomicReference.compareAndSet(yang, li)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(yang, li)+"\t"+atomicReference.get().toString());
    }
}
