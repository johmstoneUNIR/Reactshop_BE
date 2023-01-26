package com.unir.msorders.service;

import java.util.List;

import com.unir.msorders.model.pojo.RSOrders;
import com.unir.msorders.model.request.CreateRSOrder;

public interface RSOrderService {
    
    List<RSOrders> findByRsclient(String clientid);

    RSOrders getRSOrder(String orderid);

    RSOrders createRSOrder(CreateRSOrder request);

}
