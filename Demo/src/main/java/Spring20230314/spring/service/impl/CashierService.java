package Spring20230314.spring.service.impl;

import Spring20230314.spring.service.BookShopService;
import Spring20230314.spring.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

/**
 * @author yang
 * @date 2023/3/18 19:23
 */
@Service("cashier")
public class CashierService implements Cashier {


    @Autowired
    private BookShopService bookShopService;

    @Transient
    @Override
    public void checkout(int userId, List<String> isBns) {
        for (String isBn : isBns) {

        }
    }
}
