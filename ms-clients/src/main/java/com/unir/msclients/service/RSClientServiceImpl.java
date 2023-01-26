package com.unir.msclients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.msclients.data.RSClientRepository;
import com.unir.msclients.model.pojo.RSClient;
import com.unir.msclients.model.request.CreateRSClientRequest;

@Service
public class RSClientServiceImpl implements RSClientService {

    @Autowired
    private RSClientRepository repository;

    @Override
    public List<RSClient> getRSClients() {
        List<RSClient> clients = repository.findAll();
        return clients.isEmpty() ? null : clients;
    }
    
    @Override
    public RSClient getRSClient(String clientID) {
        return repository.findById(Long.valueOf(clientID)).orElse(null);
    }

    @Override
    public RSClient createRSClient(CreateRSClientRequest request) {

        if(request != null 
                && StringUtils.hasLength(request.getFirstname().trim())
                && StringUtils.hasLength(request.getLastname().trim())
                && StringUtils.hasLength(request.getEmail().trim())
                && StringUtils.hasLength(request.getPhone().trim())
                && StringUtils.hasLength(request.getPassword().trim())
                ) {
                    RSClient rsclient = RSClient.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .phone(request.getPhone())
                        .password(request.getPassword())
                        .build();
                    return repository.save(rsclient);
                } else {
                    return null;
                }
    }    
}
