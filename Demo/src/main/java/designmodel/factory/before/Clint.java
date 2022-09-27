package designmodel.factory.before;

/**
 * @author yang
 * @date 2022/8/7 13:38
 */
public class Clint {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("lette");
        System.out.println(coffee.getName());
    }
}
