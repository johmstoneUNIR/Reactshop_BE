package com.unir.msorders.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.msorders.model.pojo.RSClient;
import com.unir.msorders.model.pojo.RSOrders;

import java.util.List;

public interface RSOrderRepository extends JpaRepository<RSOrders, Long> {
    
    //@Query("SELECT o FROM orders o JOIN o.clients c where o.clientid = :clientid")
    List<RSOrders> findByRsclient(RSClient rsclient);

}
