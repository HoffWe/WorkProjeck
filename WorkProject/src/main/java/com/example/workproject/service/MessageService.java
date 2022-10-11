package com.example.workproject.service;

import com.example.workproject.dto.MessageDtoIn;
import com.example.workproject.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MessageService {

    Message add (MessageDtoIn newMessage);
    Optional<Message> findById (long messageid);
    List<Message> findByRecipientId (long recipientId);
    List<Message> findBySenderId (long senderId);
    void deleteById(long messageId);
}
