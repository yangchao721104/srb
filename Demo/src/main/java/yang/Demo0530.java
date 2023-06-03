package yang;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import okhttp3.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2. 描述：请编写一个简单的HTTP负载均衡器，将HTTP请求分发到多个后端服务器。该负载均衡器应支持以下功能：
 * 1) 支持轮询策略，将请求依次分发给后端服务器。
 * 2) 支持后端服务器的动态添加和删除。
 * 3) 实现一个简单的健康检查机制，定期检查后端服务器的可用性，将不可用的服务器从负载均衡器中移除。
 * @author yang
 * @date 2023/5/30 21:36
 */
public class Demo0530 {

    private static AtomicInteger NEXT_SERVER_COUNTER = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server(1, "服务器1"));
        serverList.add(new Server(2, "服务器2"));
        serverList.add(new Server(3, "服务器3"));

        //2.支持后端服务器的动态添加和删除。
        //serverList.add(new Server(4, "服务器4"));
        //serverList.remove(4);

        for (int i = 0; i < 10; i++) {

            //3.实现一个简单的健康检查机制，定期检查后端服务器的可用性，将不可用的服务器从负载均衡器中移除。
            //deleteServer(serverList);

            Server selectedServer = selectServer(serverList);
            System.out.format("第%d次请求，选择服务器%s\n", i + 1, selectedServer.toString());
        }

    }

    /**
     * 删除不可用的服务器
     * @param serverList
     */
    private static List<Server> deleteServer(List<Server> serverList) {
        for (Iterator<Server> iterator = serverList.iterator(); iterator.hasNext(); ) {
            Server server = iterator.next();
            Boolean aBoolean = httpIsOk(server);
            if (!aBoolean) {
                iterator.remove();
            }
        }
        return serverList;
    }


    /**
     * 查询请求哪个服务器
     * @param modulo 服务器总数
     * @return
     */
    private static int select(int modulo) {
        for (; ; ) {
            int current = NEXT_SERVER_COUNTER.get();
            int next = (current + 1) % modulo;
            boolean compareAndSet = NEXT_SERVER_COUNTER.compareAndSet(current, next);
            if (compareAndSet) {
                return next;
            }
        }
    }

    public static Server selectServer(List<Server> serverList) {
        return serverList.get(select(serverList.size()));
    }



    /**
     * 服务器实体
      */
    @Data
    public static class Server {

        //服务器id
        private int serverId;

        //服务器名称
        private String name;

        //ip
        private String ip;

        public Server(int serverId, String name) {
            this.serverId = serverId;
            this.name = name;
        }
    }

    /**
     * 判断服务器请求是否成功
     * @param server 入参server对象
     * @return 返回true/false
     */
    public static Boolean httpIsOk(Server server) {
            String url ="http://"+server.getIp() + "端口+网关地址";
            OkHttpClient client = new OkHttpClient();
            Map paraMap = new HashMap();
            paraMap.put("yybh", "1231231");

            RequestBody requestBody = new MultipartBody.Builder()
                    .addFormDataPart("consumerAppId", "tst")
                    .addFormDataPart("serviceName", "queryCipher")
                    .addFormDataPart("params", JSON.toJSONString(paraMap))
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response response = null;
            try {
                response = client
                        .newCall(request)
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response.isSuccessful();
        }





}
