//package com.drawthink.EventListener;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//@Slf4j
//public class WebSocketEventListener {
//
//    @EventListener
//    public void handleConnectListener(SessionConnectedEvent event) {
//        log.info("[ws-connected] socket connect: {}", event.getMessage());
//
//        // do someting ...
//    }
//    @EventListener
//    public void handleDisconnectListener(SessionDisconnectEvent event) {
//        log.info("[ws-disconnect] socket disconnect: {}", event.getMessage());
//
//        // do someting ...
//    }
//}
