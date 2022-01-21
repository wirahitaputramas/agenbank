package com.example.agenbank.service;

import com.example.agenbank.model.entity.Manager;
import com.example.agenbank.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostManagerService {

    ManagerRepository managerRepository;

    public PostManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public void execute(Manager manager) {
        managerRepository.save(manager);
    }
}
