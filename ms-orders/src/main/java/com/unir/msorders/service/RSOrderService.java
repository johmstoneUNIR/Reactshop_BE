package com.unir.msorders.service;

import java.util.List;

import com.unir.msorders.model.pojo.Product;
import com.unir.msorders.model.pojo.RSOrderDetails;
import com.unir.msorders.model.pojo.RSOrders;
import com.unir.msorders.model.request.CreateRSOrderDetail;
import com.unir.msorders.model.request.createRSFullOrder;

public interface RSOrderService {
    
    List<RSOrders> findByRsclient(String clientid);

    RSOrders getRSOrder(String orderid);

    RSOrders createRSOrder(createRSFullOrder request);

    RSOrderDetails createRSOrderDetails(CreateRSOrderDetail request, RSOrders rsorder);
}
