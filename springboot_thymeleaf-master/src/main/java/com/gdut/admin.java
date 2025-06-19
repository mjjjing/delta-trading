package com.gdut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.gdut.trade.mapper")
public class admin {

    public static void main(String[] args) {
        SpringApplication.run(admin.class, args);
    }

    // 定义一个组件来监听Web服务器初始化完成事件
    @Component
    public static class ServerStartupRunner implements ApplicationListener<WebServerInitializedEvent> {

        private final Environment env;

        public ServerStartupRunner(Environment env) {
            this.env = env;
        }

        @Override
        public void onApplicationEvent(WebServerInitializedEvent event) {
            try {
                String hostAddress = env.getProperty("server.address", "127.0.0.1");
                int port = event.getWebServer().getPort();
                System.err.println("访问地址: http://" + hostAddress + ":" + port);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
