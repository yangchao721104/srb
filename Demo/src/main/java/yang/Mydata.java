package yang;

/**
 * @author yang
 * @date 2022/7/24 13:46
 */
public class Mydata {

    volatile int number = 0;
    public void addTo60() {
        this.number = 60;
    }


    public void addPlus() {
        number++;
    }

}
