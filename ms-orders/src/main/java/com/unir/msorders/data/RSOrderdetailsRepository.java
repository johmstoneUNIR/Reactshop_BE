package com.unir.msorders.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.msorders.model.pojo.RSOrderDetails;
import com.unir.msorders.model.pojo.RSOrders;

public interface RSOrderdetailsRepository extends JpaRepository<RSOrderDetails,Long> {
    
    List<RSOrderDetails> findByRsorder(RSOrders rsorder);
}
