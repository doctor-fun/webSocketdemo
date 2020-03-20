package com.drawthink.config;

//import com.drawthink.Interceptor.WebSocketHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by lincoln on 16-10-25
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/hello").setAllowedOrigins("*").withSockJS();
        stompEndpointRegistry.addEndpoint("/cheat").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic","/user");
        registry.setApplicationDestinationPrefixes("/app/");
        registry.setUserDestinationPrefix("/user/");
    }
//    //添加拦截器，发送信息时要添加用户
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.setInterceptors(new WebSocketHandlerInterceptor());
//    }
}
