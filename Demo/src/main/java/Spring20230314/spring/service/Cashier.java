package Spring20230314.spring.service;

import java.util.List;

/**
 * @author yang
 * @date 2023/3/18 19:22
 */
public interface Cashier {

    /**
     * 去结账
     */
    void checkout(int userId, List<String> isBns);
}
