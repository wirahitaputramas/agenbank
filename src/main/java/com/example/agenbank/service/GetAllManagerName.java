package com.example.agenbank.service;

import com.example.agenbank.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllManagerName {

    ManagerRepository managerRepository;

    public GetAllManagerName(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<String> execute() {
        return managerRepository.findAllManagerName()
                .stream().map(String::toUpperCase)
                .collect(Collectors.toList());
    }

}
