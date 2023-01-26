package com.unir.msorders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.msorders.data.RSClientRepository;
import com.unir.msorders.data.RSOrderRepository;
import com.unir.msorders.model.pojo.RSClient;
import com.unir.msorders.model.pojo.RSOrders;
import com.unir.msorders.model.request.CreateRSOrder;


import java.util.List;

@Service
public class RSOrderServiceImpl implements RSOrderService {
    
    @Autowired
    private RSOrderRepository repository;

    @Autowired
    private RSClientRepository clientRepository;

    @Override
    public List<RSOrders> findByClientID(String clientid) {

        //RSClient rsclient = clientRepository.findById(Long.valueOf(clientid)).orElse(null);
        List<RSOrders> data = repository.findBy(null, null)
        return data;
    }

    @Override
    public RSOrders getRSOrder(String orderid) {
       return repository.findById(Long.valueOf(orderid)).orElse(null);
    }

    @Override
    public RSOrders createRSOrder(CreateRSOrder request) {
        if(
            request != null
            && StringUtils.hasLength(request.getClientid().getClientid().toString().trim())
            && StringUtils.hasLength(request.getPaymentmethod())
        ) {
            RSOrders rsOrder = RSOrders.builder()
                .clientid(request.getClientid())
                .paymentmethod(request.getPaymentmethod())
                .paidflag(true)
                //.creationdate(creationdate: LocalDate.now())
                .build();
            
            return repository.save(rsOrder);
        } else {
            return null;
        }
    }

}
