package com.example.agenbank.repository;

import com.example.agenbank.model.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    @Query(value = "SELECT NAME FROM MANAGER M", nativeQuery = true)
    List<String> findAllManagerName();

}
