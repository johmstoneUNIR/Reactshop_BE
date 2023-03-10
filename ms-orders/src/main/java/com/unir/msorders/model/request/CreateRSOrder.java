package com.unir.msorders.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRSOrder { 
    private String clientid;
    private String paymentmethod;
    private String paidflag;
}
