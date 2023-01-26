package com.unir.msclients.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.msclients.model.pojo.RSClient;

public interface RSClientRepository extends JpaRepository<RSClient, Long> {
    
    List<RSClient> firstname(String firstname);
}
