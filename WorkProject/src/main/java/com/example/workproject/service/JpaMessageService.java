package com.example.workproject.service;

import com.example.workproject.dto.MessageDtoIn;
import com.example.workproject.model.Message;
import com.example.workproject.model.Worker;
import com.example.workproject.repository.MessageRepository;
import com.example.workproject.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JpaMessageService implements MessageService{

    private final MessageRepository messageRepository;
    private final WorkerRepository workerRepository;

    public JpaMessageService(MessageRepository messageRepository, WorkerRepository workerRepository) {
        this.messageRepository = messageRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public Message add(MessageDtoIn newMessage) {
        Message message = Message.builder()
                .title(newMessage.getTitle())
                .recipient(workerRepository.getReferenceById(newMessage.getRecipientId()))
                .sender(workerRepository.getReferenceById(newMessage.getSenderId()))
                .content(newMessage.getContent())
                .issueDate(LocalDateTime.now())
                .build();
        return messageRepository.save(message);
    }

    @Override
    public Optional<Message> findById(long messageId) {
        return messageRepository.findById(messageId);
    }

    @Override
    public List<Message> findByRecipientId(long workerId) {
        return messageRepository.findByRecipientId(workerId);
    }

    @Override
    public List<Message> findBySenderId(long senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    @Override
    public void deleteById(long messageId) {
        messageRepository.deleteById(messageId);
    }
}
