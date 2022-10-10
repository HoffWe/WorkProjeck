package com.example.workproject.controller;

import com.example.workproject.dto.MessageDtoIn;
import com.example.workproject.model.Message;
import com.example.workproject.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @PostMapping("")
    public ResponseEntity<Message> add(@RequestBody MessageDtoIn newMessage) {
        final Message message = messageService.add(newMessage);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
