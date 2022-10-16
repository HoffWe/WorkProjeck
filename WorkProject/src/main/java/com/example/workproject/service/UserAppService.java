package com.example.workproject.service;

import com.example.workproject.repository.WorkerRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserAppService implements UserDetailsService {

    private final WorkerRepository workerRepository;

    public UserAppService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return workerRepository.findByeMail(username).orElse(null);
    }
}
