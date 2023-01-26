package com.unir.msorders.model.request;
import java.time.LocalDate;

import com.unir.msorders.model.pojo.RSClient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRSOrder {    

    private RSClient clientid;
    private String paymentmethod;
    private String paidflag;
    private LocalDate creationdate;
    
}
