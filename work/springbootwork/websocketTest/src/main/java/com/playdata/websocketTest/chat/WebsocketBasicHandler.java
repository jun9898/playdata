package com.playdata.websocketTest.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
// /chat은 매핑명 
// 웹소켓 통신을 하면서 서버 역할을 하는 프로그램
@ServerEndpoint(value = "/chat")
public class WebsocketBasicHandler {

	// session을 저장하기 위한 컬렉션을 추가
	// Set인데 동기화된 컬렉션 - 멀티스레드환경에서 안정하게 작업할 수 있도록 제공되는 Set
	private static Set<Session> clientlist = Collections.synchronizedSet(new HashSet<>()) ;
	
	// 접속 시작 - 처음 접속되면 호출되는 메소드
	// 접속될때 클라이언트 정보가 Session 객체로 전달
	@OnOpen
	public void onOpen(Session client) {
		if (!clientlist.contains(client)) { // clientlist에 클라이언트가 없으면
			clientlist.add(client); // 클라이언트를 자료구조에 저장하기
			log.info("클라이언트가 접속했습니다........." + client);
		}
	}
	
	// 메시지 받으면 - 통신할때 전달되는 메시지를 받으면 호출되는 메소드로 모든 접속자들에게 메시지를 전송할 수 있도록 구현
	// 			  메시지 받을때마다 호출되는 메소드
	// 			  텍스트메시지 통신(웹소켓에 접속한 모든 클라이언트에게 메시지를 전송)
	@OnMessage
	public void onMessage(String msg, Session sender) throws IOException {
		// 웹소켓에 접속한 모든 클라이언트에게 메시지 전송하기
		log.info("수신메시지 : " + msg);
		for (Session client : clientlist) {
			log.info("전송할 메시지 : " + msg);
			client.getBasicRemote().sendText(msg); // 텍스트메시지 전송하기
		}
	}
	
	
	// 접속 종료시점 - 소켓 연결이 끊어지면 호출되는 메소드
	@OnClose
	public void onClose(Session client) {
		log.info("접속 종료......." + client);
		clientlist.remove(client); // 웹소켓세션을 저장하는 자료구조에서 빼기
	}
	
	// 오류가 발생하면
//	@OnError

}
