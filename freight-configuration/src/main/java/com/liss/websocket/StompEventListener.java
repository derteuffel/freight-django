package com.liss.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class StompEventListener implements ApplicationListener<SessionConnectEvent> {
private static Logger logger = LoggerFactory.getLogger(StompEventListener.class);
 
 @Override
 public void onApplicationEvent(SessionConnectEvent event) {
 
	 System.out.println("onApplicationEvent");
	 System.out.println(event.toString());
		// String userId = event.getUser().getName();
		// StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		// boolean isConnect = sha.getCommand() == StompCommand.CONNECT;
		// boolean isDisconnect = sha.getCommand()== StompCommand.DISCONNECT;
		// logger.debug("Connect:"+ isConnect +",disconnect:" +isDisconnect +
		//", event [sessionId:" + sha.getSessionId() +";" + userId +" ,command=" +sha.getCommand() );
		// 
 }
 
 @EventListener
 public void onSocketConnected(SessionConnectedEvent event) {
	 
	 System.out.println("onSocketConnected");
	 System.out.println(event.toString());
	//	 StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
	//	 logger.info("[Connected]" + sha.getUser().getName());
 }
@EventListener
 public void onSocketDisconnected(SessionDisconnectEvent event) {
	System.out.println("onSocketDisconnected");
	System.out.println(event.toString());
//	 StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
//	 logger.info("[Disonnected]" + sha.getUser().getName());
 }


}

