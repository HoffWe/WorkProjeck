package com.example.workproject.service;

import com.example.workproject.dto.MessageDtoIn;
import com.example.workproject.model.Message;
import com.example.workproject.model.Worker;
import com.example.workproject.repository.MessageRepository;
import com.example.workproject.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JpaMessageService implements MessageService{

    private final MessageRepository messageRepository;


    public JpaMessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message add(MessageDtoIn newMessage) {
        Message message = Message.builder()
                .title(newMessage.getTitle())
                .recipient(Worker.builder().id(newMessage.getRecipientId()).build())
                .content(newMessage.getContent()).build();
        return messageRepository.save(message);
    }

    @Override
    public Optional<Message> findById(long messageid) {
        return messageRepository.findById(messageid);
    }

    @Override
    public List<Message> findByRecipientId(long workerId) {
        return messageRepository.findByRecipientId(workerId);
    }


    @Override
    public void deleteById(long messageId) {
        messageRepository.deleteById(messageId);
    }
}
