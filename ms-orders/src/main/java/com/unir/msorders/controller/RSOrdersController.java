package com.unir.msorders.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unir.msorders.model.pojo.RSOrders;
import com.unir.msorders.service.RSOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RSOrdersController {
    
    private final RSOrderService service;

    @GetMapping("/orders/{ClientID}")
    public ResponseEntity<List<RSOrders>> getOrders(@PathVariable String ClientID) {

        List<RSOrders> rsOrders = service.findByRsclient(ClientID);
        if(rsOrders != null) {
            return ResponseEntity.ok(rsOrders);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
}
