package com.unir.msorders.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.msorders.model.pojo.RSOrders;

import java.util.List;

public interface RSOrderRepository extends JpaRepository<RSOrders, Long> {
    
    List<RSOrders> findByclientid(Long clientid);

}
