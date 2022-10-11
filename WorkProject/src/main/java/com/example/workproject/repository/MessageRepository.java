package com.example.workproject.repository;


import com.example.workproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByRecipientId(long WorkerId);
    List<Message> findBySenderId (long WorkerId);
}
