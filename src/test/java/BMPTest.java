import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;

import java.io.IOException;

public class BMPTest {


    public static void main(String[] args) throws IOException {
        // 声明BrowserMobProxy代理对象
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        // 设置代理端口 ：8080
        proxy.start(8080);
        // 获取到当前代理端口
        int port = proxy.getPort(); // get the JVM-assigned port

        // 创建相应过滤器  在过滤器内可对截取得到的响应进行更改后再做相应
        proxy.addResponseFilter((response, contents, messageInfo) -> {
            // 解惑所有包含.json 的URL
            if (messageInfo.getOriginalUrl().contains(".json")) {
                //todo: json -> hashmap -> rescue -> hashmap -> json
                // 将: 后的内容转换为null
                String contentNew = contents.getTextContents().replaceAll(":\"[^\"]*\"", "null");
                // 将响应内容进行替换
                contents.setTextContents(contentNew);
            }
        });

//        proxy.addRequestFilter(((request, contents, messageInfo) -> {
//            request.setUri("/");
//            return null;
//        }));

        System.in.read();
    }
}
