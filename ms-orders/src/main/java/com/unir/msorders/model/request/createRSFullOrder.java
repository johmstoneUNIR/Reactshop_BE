package com.unir.msorders.model.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class createRSFullOrder {
    private String clientid;
    private String paymentmethod;
    private List<CreateRSOrderDetail> details;    
}
