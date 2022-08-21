package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.models.User;
import com.example.springbootwebsocket.models.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {
    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user) {
        return new UserResponse(HtmlUtils.htmlEscape(user.getName()));
    }
}
