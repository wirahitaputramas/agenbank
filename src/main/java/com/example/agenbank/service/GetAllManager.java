package com.example.agenbank.service;

import com.example.agenbank.model.entity.Manager;
import com.example.agenbank.repository.ManagerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetAllManager {

    ManagerRepository managerRepository;

    public GetAllManager(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Page<Manager> execute(Pageable pageable) {
        return managerRepository.findAll(pageable);
    }
}
