package com.playdata.websocketTest.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketTestController {
	
	@GetMapping("/chat")
	public String showView() {
		return "chat";
	}
}
