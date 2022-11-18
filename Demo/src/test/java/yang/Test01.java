package yang;



import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

/**
 * @author yang
 * @date 2022/7/19 0:31
 */
@Slf4j
public class Test01 {

    @Autowired
    ThreadPoolExecutor executor;
    /** 卡号位数：8 */
    public static byte CARD_NUM_BIT = 8;

    /**
     * 10进制转16进制，并补齐卡号位数
     *
     * @param str
     * @return
     */
    @Test
    public void toHexStr(String str) {

    }
    /**
     * isBlank
     *
     * @param value
     * @return true: blank; false: not blank
     */
    private static boolean isBlank(String value) {
        if (value == null || "".equals(value.trim())) {
            return true;
        }
        return false;
    }

    @Test
    public void test01() throws InterruptedException {

    }

}


