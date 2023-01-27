package com.unir.msorders.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unir.msorders.model.pojo.RSOrderDetails;
import com.unir.msorders.model.pojo.RSOrders;
import com.unir.msorders.model.request.CreateRSOrderDetail;
import com.unir.msorders.model.request.createRSFullOrder;
import com.unir.msorders.service.RSOrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
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

    @PostMapping("/Orders")
    public ResponseEntity<RSOrders> createRSOrder(@RequestBody createRSFullOrder request) {

        RSOrders rsOrder = service.createRSOrder(request);
        
        if(rsOrder != null){
            log.info("Order #{} created.", rsOrder.getOrderid());

            for (CreateRSOrderDetail rsOrderDetails : request.getDetails()) {
                RSOrderDetails rsod = service.createRSOrderDetails(rsOrderDetails, rsOrder);
                log.info("Request received for product {}", rsOrderDetails.getProductid());     
                log.info("Request received for orid {}", rsod.getOdid());     
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(rsOrder);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
