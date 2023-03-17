package com.qhy.springcloud.service.controller;

import com.qhy.springcloud.service.impl.MessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
    @Autowired
    private MessageProviderImpl messageProvider;

    @RequestMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
