package com.unir.msclients.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unir.msclients.model.pojo.RSClient;
import com.unir.msclients.model.request.CreateRSClientRequest;
import com.unir.msclients.service.RSClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RSClientController {
    
    private final RSClientService service;

    @GetMapping("/clients")
    public ResponseEntity<List<RSClient>> getRSClients() {
        List<RSClient> clients = service.getRSClients();
        if(clients != null) {
            return ResponseEntity.ok(clients);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/clients/{ClientID}")
    public ResponseEntity<RSClient> getProduct(@PathVariable String ClientID) {

        log.info("Request received for product {}", ClientID);
        RSClient rsclient = service.getRSClient(ClientID);

        if(rsclient != null){
            return ResponseEntity.ok(rsclient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/clients")
    public ResponseEntity<RSClient> getProduct(@RequestBody CreateRSClientRequest request) {
  
        RSClient createRSClient = service.createRSClient(request);
  
      if (createRSClient != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createRSClient);
      } else {
        return ResponseEntity.badRequest().build();
      }  
    }
}
