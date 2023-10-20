package com.playdata.websocketTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
// 웹소켓 컨테이너를 활성화시키는 작업
@EnableWebSocket
public class WebsocketConfig {
	
	// 설정파일은 전부 퍼블릭임
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

}
