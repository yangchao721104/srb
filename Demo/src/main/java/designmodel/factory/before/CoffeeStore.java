package designmodel.factory.before;

/**
 * @author yang
 * @date 2022/8/7 13:32
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type){
        Coffee coffee = null;
        if ("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if ("lette".equals(type)){
            coffee = new LatteCoffee();
        }else {
            throw new RuntimeException("对不起，别的咖啡没有了");
        }
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
