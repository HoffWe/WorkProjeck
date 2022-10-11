package com.example.workproject.controller;

import com.example.workproject.dto.MessageDtoIn;
import com.example.workproject.dto.MessageDtoOut;
import com.example.workproject.mapper.MessageToDto;
import com.example.workproject.model.Message;
import com.example.workproject.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody MessageDtoIn newMessage) {
        final Message message = messageService.add(newMessage);
        return ResponseEntity.status(HttpStatus.CREATED).body("Wiadomość wysłana pomyślnie");
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDtoOut> get(@PathVariable long id){
        final Optional<Message>optionalMessage = messageService.findById(id);
        return optionalMessage.map(message -> ResponseEntity.ok(MessageToDto.mapToDto(message))).orElse(ResponseEntity.of(Optional.empty()));
    }
    @GetMapping("/sendedMessage/{id}")
    public List<MessageDtoOut> findBySenderId (@PathVariable long id){
        return messageService.findBySenderId(id).stream()
                .map(MessageToDto::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/recivedMessage/{id}")
    public List<MessageDtoOut> findByRecipientId (@PathVariable long id){
        return messageService.findByRecipientId(id).stream()
                .map(MessageToDto::mapToDto)
                .collect(Collectors.toList());
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
            messageService.deleteById(id);
    }
}
