package com.unir.msorders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.msorders.data.ProductRepository;
import com.unir.msorders.data.RSClientRepository;
import com.unir.msorders.data.RSOrderRepository;
import com.unir.msorders.data.RSOrderdetailsRepository;
import com.unir.msorders.model.pojo.Product;
import com.unir.msorders.model.pojo.RSClient;
import com.unir.msorders.model.pojo.RSOrderDetails;
import com.unir.msorders.model.pojo.RSOrders;
import com.unir.msorders.model.request.CreateRSOrderDetail;
import com.unir.msorders.model.request.createRSFullOrder;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class RSOrderServiceImpl implements RSOrderService {

    @Autowired
    private RSOrderRepository repository;

    @Autowired
    private RSClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private RSOrderdetailsRepository orderdetailsRepository;

    @Override
    public List<RSOrders> findByRsclient(String clientid) {

        RSClient rsclient = clientRepository.findById(Long.valueOf(clientid)).orElse(null);
        List<RSOrders> data = repository.findByRsclient(rsclient);
        // data.forEach(n ->
        // n.setRsorderdetails(orderdetailsRepository.findByRsorder(n)));
        return data;
    }

    @Override
    public RSOrders getRSOrder(String orderid) {
        return repository.findById(Long.valueOf(orderid)).orElse(null);
    }

    @Override
    public RSOrders createRSOrder(createRSFullOrder request) {
        if (request != null
                && StringUtils.hasLength(request.getClientid().trim())
                && StringUtils.hasLength(request.getPaymentmethod())
                && request.getDetails().size() > 0) {
            RSClient rsClient = clientRepository.findById(Long.valueOf(request.getClientid())).orElse(null);

            RSOrders rsOrder = RSOrders.builder()
                    .rsclient(rsClient)
                    .paymentmethod(request.getPaymentmethod())
                    .paidflag(true)
                    .creationdate(LocalDate.now())
                    .build();

            // for (CreateRSOrderDetail rsOrderDetails : request.getDetails()) {
            //     log.info("request of RSOD: {}", rsOrderDetails.getProductid());
            //     RSOrderDetails rsO = RSOrderDetails.builder()
            //             .rsorder(rsOrder)
            //             .productid(rsOrderDetails.getProductid())
            //             .qty(rsOrderDetails.getQty())
            //             .subtotal(rsOrderDetails.getSubtotal())
            //             .iva(rsOrderDetails.getIva())
            //             .build();
            // }
            return repository.save(rsOrder);
        } else {
            return null;
        }
    }

    @Override
    public RSOrderDetails createRSOrderDetails(CreateRSOrderDetail request, RSOrders rsorder) {
        // log.info("Data load: {},{},{},{},{}.", orderid,request.getProductid(),request.getQty(),request.getSubtotal(), request.getIva());

        Product product = productRepository.findById(Long.valueOf(request.getProductid())).orElse(null);

        RSOrderDetails rsO = RSOrderDetails.builder()
                .rsorder(rsorder)
                .product(product)
                .qty(request.getQty())
                .subtotal(request.getSubtotal())
                .iva(request.getIva())
                .build();
        return orderdetailsRepository.save(rsO);
    }

}
