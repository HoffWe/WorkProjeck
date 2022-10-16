package com.example.workproject.repository;


import com.example.workproject.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {

    Optional<Worker> findByeMail( String eMail);
}
